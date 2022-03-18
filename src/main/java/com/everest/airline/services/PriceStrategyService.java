package com.everest.airline.services;

import com.everest.airline.DTO.FlightDTO;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

@Component
public class PriceStrategyService {
    @Autowired
    private FlightDTO flightDTO;

    public void updateTotalFaire(Flight flight,int numberOfPassengers,String classType,String todayDate) throws ParseException {
        double totalFaire = calculateTotalFaire(flight, numberOfPassengers, classType,todayDate);
        flight.setTotalFair(totalFaire);
    }

    public double calculateTotalFaire(Flight flight, int numberOfPassengers, String classType,String todayDate) throws ParseException {
        double todayTicketCost=getTicketCost(classType,flight,todayDate);
        double totalFaire = todayTicketCost * numberOfPassengers;
        return totalFaire;
    }
    public double getTicketCost(String classType, Flight flight, String todayDate) throws ParseException {
        int baseCost=flightDTO.getCostOfSeat(classType, flight);
        String departureDate = flight.getDepartureDate();
        int totalSeats=flight.getNumberOfTotalSeats();
        int availableSeats=flight.getNumberOfAvailableSeats(classType);
        double multiplyFactorOfAvailableSeats=getPriceFactorByLeftOverSeats(availableSeats,totalSeats)/100;
        double multiplicationFactorOfDateOfBook=getPriceFactorByDate(departureDate,todayDate)/100;
        System.out.println("increase factor="+multiplicationFactorOfDateOfBook);
        return baseCost+baseCost*(multiplyFactorOfAvailableSeats+multiplicationFactorOfDateOfBook);

    }

    private double getPriceFactorByDate(String departureDate, String todayDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(todayDate);
        Calendar toDayDateAndTime = Calendar.getInstance();
        toDayDateAndTime.setTime(date);
        date = formatter.parse(departureDate);
        Calendar departureDateAndTime= Calendar.getInstance();
        departureDateAndTime.setTime(date);
        long days = Duration.between(toDayDateAndTime.toInstant(), departureDateAndTime.toInstant()).toDays();
        System.out.println("todays date ="+toDayDateAndTime.getTime());
        System.out.println("departureDate = "+departureDateAndTime.getTime());
        System.out.println("diff"+days);
        if(days>15)
        return 0;
        if(days>10){
            long nofDaysLate=15-days;
            return nofDaysLate*1;
        }
        if(days>3){
            long nofDaysLate=10-days;
            return nofDaysLate*2;
        }
        if(days>=0){
            long nofDaysLate=3-days;
            return nofDaysLate*10;
        }
        System.out.println("werfghjiolm");
        return days;
    }

    private int getPriceFactorByLeftOverSeats(int availableSeats, int totalSeats) {
        int soldOutTickets=totalSeats-availableSeats;
        int factor=1;
        if(soldOutTickets<Math.floor(totalSeats*0.3)){
            return 0;
        }
        if(soldOutTickets<Math.floor(totalSeats*0.5)){
            return 20;
        }
        if(soldOutTickets<Math.floor(totalSeats*0.75)){
            return 35;
        }
        if(soldOutTickets<totalSeats){
            return 50;
        }
        return factor;
    }

}
