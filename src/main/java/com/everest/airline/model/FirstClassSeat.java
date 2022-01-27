package com.everest.airline.model;

public class FirstClassSeat implements ISeat {
    private int totalNumberOfFirstClassSeats;
    private int numberOfAvailableFirstClassSeats;
    private int FirstClassBasePrice;

    public FirstClassSeat(){}
    public FirstClassSeat(int totalNumberOfSeats, int numberOfAvailableSeats, int basePrice) {
        this.totalNumberOfFirstClassSeats = totalNumberOfSeats;
        this.numberOfAvailableFirstClassSeats = numberOfAvailableSeats;
        this.FirstClassBasePrice = basePrice;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfFirstClassSeats = totalNumberOfSeats;
    }

    public void setBasePrice(int basePrice) {

        this.FirstClassBasePrice = basePrice;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableFirstClassSeats = numberOfAvailableSeats;
    }

    @Override
    public void upDateSeats(int noOfEconomicTickets) {
        this.numberOfAvailableFirstClassSeats -= noOfEconomicTickets;
    }

    @Override
    public int getNumberOfAvailableSeats() {
        return this.numberOfAvailableFirstClassSeats;
    }

    @Override
    public int getTotalNumberOfSeats() {
        return this.totalNumberOfFirstClassSeats;
    }

    public int getBasePrice() {
        return this.FirstClassBasePrice;
    }

    @Override
    public String toString() {
        return totalNumberOfFirstClassSeats +","+ numberOfAvailableFirstClassSeats +","+ FirstClassBasePrice;
    }
}

