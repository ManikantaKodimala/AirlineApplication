package com.everest.airline.model;

public class EconomicClassSeat implements ISeat {
    private int totalNumberOfEconomicClassSeats;
    private int numberOfAvailableEconomicSeats;
    private int EconomicClassBasePrice;

    public EconomicClassSeat(){}

    public EconomicClassSeat(int totalNumberOfSeats, int numberOfAvailableSeats, int basePrice) {
        this.totalNumberOfEconomicClassSeats = totalNumberOfSeats;
        this.numberOfAvailableEconomicSeats = numberOfAvailableSeats;
        this.EconomicClassBasePrice = basePrice;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfEconomicClassSeats = totalNumberOfSeats;
    }

    public void setBasePrice(int basePrice) {

        this.EconomicClassBasePrice = basePrice;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableEconomicSeats = numberOfAvailableSeats;
    }

    @Override
    public void upDateSeats(int noOfEconomicTickets) {
        this.numberOfAvailableEconomicSeats -= noOfEconomicTickets;
    }

    @Override
    public int getNumberOfAvailableSeats() {
        return this.numberOfAvailableEconomicSeats;
    }

    @Override
    public int getTotalNumberOfSeats() {
        return this.totalNumberOfEconomicClassSeats;
    }

    public int getBasePrice() {
        return this.EconomicClassBasePrice;
    }

    @Override
    public String toString() {
        return "" + totalNumberOfEconomicClassSeats +"," + numberOfAvailableEconomicSeats +"," + EconomicClassBasePrice;
    }
}
