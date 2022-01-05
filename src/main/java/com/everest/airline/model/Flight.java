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

    public Flight(){}
    public Flight(long number, String source, String destination, Calendar departureDateTime, Calendar arrivalDateTime, int noOfTotalSeats, int noOfSeatsAvailable, int availableBusinessClassSeats, int availableFirstClassSeats, int availableSecondClassSeats, int availableEconomicClassSeats) {
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

    public void setSource(String source){
        this.source=source;
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

    public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
        this.noOfSeatsAvailable = noOfSeatsAvailable;
    }

    public void setAvailableBusinessClassSeats(int availableBusinessClassSeats) {
        this.availableBusinessClassSeats = availableBusinessClassSeats;
    }

    public void setAvailableEconomicClassSeats(int availableEconomicClassSeats) {
        this.availableEconomicClassSeats = availableEconomicClassSeats;
    }

    public void setAvailableFirstClassSeats(int availableFirstClassSeats) {
        this.availableFirstClassSeats = availableFirstClassSeats;
    }

    public void setAvailableSecondClassSeats(int availableSecondClassSeats) {
        this.availableSecondClassSeats = availableSecondClassSeats;
    }

    public void setBusinessClassTicketCost(int businessClassTicketCost) {
        this.businessClassTicketCost = businessClassTicketCost;
    }

    public void setFirstClassTicketCost(int firstClassTicketCost) {
        this.firstClassTicketCost = firstClassTicketCost;
    }

    public void setSecondClassTicketCost(int secondClassTicketCost) {
        this.secondClassTicketCost = secondClassTicketCost;
    }

    public void setEconomicClassTicketCost(int economicClassTicketCost) {
        this.economicClassTicketCost = economicClassTicketCost;
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
