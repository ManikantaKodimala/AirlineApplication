package com.everest.airline.model;

public interface ISeat {
    void upDateSeats(int noOfEconomicTickets);
     int getNumberOfAvailableSeats();
     int getTotalNumberOfSeats();

    int getBasePrice();
}
