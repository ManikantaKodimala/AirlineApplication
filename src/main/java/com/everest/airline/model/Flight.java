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
    private int numberOfTotalSeats;
    private double totalFair = 0;
    private Seat seats;

    public Flight(long number, String source, String destination, Calendar departureDateTime, Calendar arrivalDateTime, int noOfTotalSeats) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.numberOfTotalSeats = noOfTotalSeats;
    }

    public Flight() {
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

    public void setSource(String source) {
        this.source = source;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDateTime(Calendar departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setNumberOfTotalSeats(int numberOfTotalSeats) {
        this.numberOfTotalSeats = numberOfTotalSeats;
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

    public String getDepartureDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = this.departureDateTime.getTime();
        return formatter.format(date);
    }

    public String getDepartureTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        Date date = this.departureDateTime.getTime();
        return formatter.format(date);
    }

    public String getArrivalDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = this.arrivalDateTime.getTime();
        return formatter.format(date);
    }

    public String getArrivalTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        Date date = this.arrivalDateTime.getTime();
        return formatter.format(date);
    }

    public int getNumberOfTotalSeats() {
        return numberOfTotalSeats;
    }

    public double getTotalFair() {
        return totalFair;
    }

    public void setTotalFair(double totalFair) {
        this.totalFair = totalFair;
    }

    public void setSeats(Seat seats) {
        this.seats = seats;
    }

    public int getTotalNumberOfSeats(String classType) {
        return this.seats.getTotalNumberOfSeats(classType);
    }

    public int getNumberOfAvailableSeats(String classType) {
        return this.seats.getNumberOfAvailableSeats(classType);
    }

    public void upDateSeats(String classType, int noOfTickets) {
        this.seats.upDateSeats(classType, noOfTickets);
    }

    public int getBasePrice(String classType) {
        return this.seats.getBasePrice(classType);
    }

    public String getSeatsDetails() {
        return this.seats.toString();
    }
}
