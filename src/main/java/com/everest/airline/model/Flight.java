package com.everest.airline.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Flight {
    private long number;
    private String source;
    private String destination;
    private Calendar departureDateTime;
    private Calendar arrivalDateTime;
    private int noOfTotalSeats;
    private int noOfSeatsAvailable;
    private int noOfPassengersPerBook =1;

    public Flight(long number, String source, String destination,Calendar departureDateTime,Calendar arrivalDateTime,int noOfTotalSeats, int noOfSeatsAvailable) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDateTime=departureDateTime;
        this.arrivalDateTime=arrivalDateTime;
        this.noOfSeatsAvailable=noOfSeatsAvailable;
        this.noOfTotalSeats=noOfTotalSeats;
    }

    public long getNumber() {
        return number;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureDateTime() {
        return departureDateTime.getTime();
    }

    public void setDepartureDate(Calendar departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime.getTime();
    }

    public void setArrivalDateTime(Calendar arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }
    public String getDepartureDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=this.departureDateTime.getTime();
        return formatter.format(date);
    }
    public String getDepartureTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        Date date=this.departureDateTime.getTime();
        return formatter.format(date);
    }
    public String getArrivalDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=this.arrivalDateTime.getTime();
        return formatter.format(date);
    }
    public String getArrivalTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        Date date=this.arrivalDateTime.getTime();
        return formatter.format(date);
    }
    public int getAvailableSeats(){
        return this.noOfSeatsAvailable;
    }

    public String getFlightDetails(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getNumber()+",");
        sb.append(this.getSource()+",");
        sb.append(this.getDestination()+",");
        sb.append(this.getDepartureDate()+" "+this.getDepartureTime()+",");
        sb.append(this.getArrivalDate()+" "+this.getArrivalTime()+",");
        sb.append(this.getNoOfTotalSeats()+",");
        sb.append(this.getAvailableSeats());
        return sb.toString();
    }

    public int getNoOfTotalSeats() {
        return noOfTotalSeats;
    }


    public void setAvailableSeats() {
        this.noOfSeatsAvailable-=this.noOfPassengersPerBook;
    }
}
