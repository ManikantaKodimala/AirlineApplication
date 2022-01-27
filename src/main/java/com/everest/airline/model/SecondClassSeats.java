package com.everest.airline.model;

public class SecondClassSeats implements ISeat {
    private int totalNumberOfSecondClassSeats;
    private int numberOfAvailableSecondClassSeats;
    private int SecondClassBasePrice;

    public SecondClassSeats(){}
    public SecondClassSeats(int totalNumberOfSeats, int numberOfAvailableSeats, int basePrice) {
        this.totalNumberOfSecondClassSeats = totalNumberOfSeats;
        this.numberOfAvailableSecondClassSeats = numberOfAvailableSeats;
        this.SecondClassBasePrice = basePrice;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSecondClassSeats = totalNumberOfSeats;
    }

    public void setBasePrice(int basePrice) {
        this.SecondClassBasePrice = basePrice;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSecondClassSeats = numberOfAvailableSeats;
    }

    @Override
    public void upDateSeats(int noOfEconomicTickets) {
        this.numberOfAvailableSecondClassSeats -= noOfEconomicTickets;
    }

    @Override
    public int getNumberOfAvailableSeats() {
        return this.numberOfAvailableSecondClassSeats;
    }

    @Override
    public int getTotalNumberOfSeats() {
        return this.totalNumberOfSecondClassSeats;
    }

    public int getBasePrice() {
        return this.SecondClassBasePrice;
    }

    public String toString() {
        return totalNumberOfSecondClassSeats +"," + numberOfAvailableSecondClassSeats +"," + SecondClassBasePrice;
    }
}
