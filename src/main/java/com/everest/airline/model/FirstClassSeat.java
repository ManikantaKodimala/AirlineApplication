package com.everest.airline.model;

public class FirstClassSeat implements ISeat {
    private int totalNumberOfSeats;
    private int numberOfAvailableSeats;
    private int basePrice;

    public FirstClassSeat(int totalNumberOfSeats, int numberOfAvailableSeats, int basePrice) {
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.basePrice = basePrice;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public void setBasePrice(int basePrice) {

        this.basePrice = basePrice;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    @Override
    public void upDateSeats(int noOfEconomicTickets) {
        this.numberOfAvailableSeats -= noOfEconomicTickets;
    }

    @Override
    public int getNumberOfAvailableSeats() {
        return this.numberOfAvailableSeats;
    }

    @Override
    public int getTotalNumberOfSeats() {
        return this.totalNumberOfSeats;
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    @Override
    public String toString() {
        return totalNumberOfSeats +","+ numberOfAvailableSeats +","+ basePrice;
    }
}

