package com.everest.airline.model;

public class Seat {
    private EconomicClassSeat economicClass;
    private SecondClassSeats secondClass;
    private FirstClassSeat firstClass;

    public Seat(EconomicClassSeat economicClass, SecondClassSeats secondClass, FirstClassSeat firstClass) {
        this.economicClass = economicClass;
        this.secondClass = secondClass;
        this.firstClass = firstClass;
    }

    public void upDateSeats(String classType, int noOfTickets) {
        ISeat seat=getSeatType(classType);
        seat.upDateSeats(noOfTickets);
    }

    public int getNumberOfAvailableSeats(String classType) {
        ISeat seat=getSeatType(classType);
        return seat.getNumberOfAvailableSeats();
    }

    public int getTotalNumberOfSeats(String classType) {
        ISeat seat=getSeatType(classType);
        return seat.getNumberOfAvailableSeats();
    }

    public int getBasePrice(String classType){
        ISeat seat=getSeatType(classType);
        return seat.getBasePrice();
    }

    private ISeat getSeatType(String classType) {
        switch (classType) {
            case "firstClass":
                return this.firstClass;
            case "secondClass":
                return this.secondClass;
            case "economicClass":
                return this.economicClass;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return economicClass.toString() +","+secondClass.toString()+"," + firstClass.toString();
    }
}
