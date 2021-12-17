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
    private int noOfSeatsAvailable;
    private int availableBusinessClassSeats;
    private int availableEconomicClassSeats;
    private int availableFirstClassSeats;
    private int availableSecondClassSeats;
    private int businessClassTicketCost = 500;
    private int firstClassTicketCost = 400;
    private int secondClassTicketCost = 300;
    private int economicClassTicketCost = 200;
    private double totalFair=0;

    public Flight(long number, String source, String destination, Calendar departureDateTime, Calendar arrivalDateTime, int noOfTotalSeats, int noOfSeatsAvailable, int availableBusinessClassSeats,
                  int availableFirstClassSeats,
                  int availableSecondClassSeats,
                  int availableEconomicClassSeats) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.noOfSeatsAvailable = noOfSeatsAvailable;
        this.numberOfTotalSeats = noOfTotalSeats;
        this.availableBusinessClassSeats = availableBusinessClassSeats;
        this.availableFirstClassSeats = availableFirstClassSeats;
        this.availableSecondClassSeats = availableSecondClassSeats;
        this.availableEconomicClassSeats = availableEconomicClassSeats;
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

    public int getAvailableSeats() {
        return this.noOfSeatsAvailable;
    }

    public int getNumberOfTotalSeats() {
        return numberOfTotalSeats;
    }


    public void setAvailableSeats(int noOfPassengersPerBook) {
        this.noOfSeatsAvailable -= noOfPassengersPerBook;
    }

    public void upDateEconomicClassSeats(int noOfEconomicTickets) {
        this.availableEconomicClassSeats -= noOfEconomicTickets;
        setAvailableSeats(noOfEconomicTickets);
    }

    public void upDateBusinessClassSeats(int noOfBusinessClassTickets) {
        this.availableBusinessClassSeats -= noOfBusinessClassTickets;
        setAvailableSeats(noOfBusinessClassTickets);
    }

    public void upDateFirstClassSeats(int noOfFirstClassTickets) {
        this.availableFirstClassSeats -= noOfFirstClassTickets;
        setAvailableSeats(noOfFirstClassTickets);
    }

    public void upDateSecondClassSeats(int noOfSecondClassTickets) {
        this.availableSecondClassSeats -= noOfSecondClassTickets;
        setAvailableSeats(noOfSecondClassTickets);
    }

    public int getAvailableBusinessClassSeats() {
        return availableBusinessClassSeats;
    }

    public int getAvailableEconomicClassSeats() {
        return availableEconomicClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return availableFirstClassSeats;
    }

    public int getAvailableSecondClassSeats() {
        return availableSecondClassSeats;
    }

    public int getEconomicClassTicketCost() {
        return economicClassTicketCost;
    }

    public int getSecondClassTicketCost() {
        return secondClassTicketCost;
    }

    public int getFirstClassTicketCost() {
        return firstClassTicketCost;
    }

    public int getBusinessClassTicketCost() {
        return businessClassTicketCost;
    }

    public int getAvailableSeatsOf(String classType) {
        switch (classType) {
            case "businessClass":
                return this.availableBusinessClassSeats;
            case "firstClass":
                return this.availableFirstClassSeats;
            case "secondClass":
                return this.availableSecondClassSeats;
            case "economicClass":
                return this.availableEconomicClassSeats;
            default:
                return -1;
        }
    }


    public double getTotalFair() {
        return totalFair;
    }

    public void setTotalFair(double totalFair) {
        this.totalFair = totalFair;
    }
}
