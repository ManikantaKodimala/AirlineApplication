package com.everest.airline.services;

import com.everest.airline.DTO.FlightDTO;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceStrategyService {
    @Autowired
    private FlightDTO flightDTO;

    public void updateTotalFaire(Flight flight,int numberOfPassengers,String classType){
         calculateTotalFaire(flight,numberOfPassengers,classType);
    }

    public void calculateTotalFaire(Flight flight, int numberOfPassengers, String classType) {
        double todayTicketCost=getTicketCost(classType,flight);
        double totalFaire = todayTicketCost * numberOfPassengers;
        flight.setTotalFair(totalFaire);
    }
    public double getTicketCost(String classType, Flight flight) {
        int baseCost=flightDTO.getCostOfSeat(classType, flight);
        int totalSeats=flight.getNumberOfTotalSeats();
        int availableSeats=flight.getAvailableSeats();
        int multiplyFactor=getPriceFactorByLeftOverSeats(availableSeats,totalSeats);
        System.out.println("increase factor="+multiplyFactor);
        return baseCost*multiplyFactor;

    }
    private int getPriceFactorByLeftOverSeats(int availableSeats, int totalSeats) {
        int soldOutTickets=totalSeats-availableSeats;
        int factor=1;
        if(soldOutTickets<Math.floor(totalSeats*0.3)){
            return factor;
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
