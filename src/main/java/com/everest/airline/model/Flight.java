package com.everest.airline.model;


import java.time.LocalDateTime;

//@Entity
//@Table(name = "flight")
public class Flight {
//    @Id
    private long number;
    private String source;
    private String destination;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int numberOfTotalSeats;
    private double totalFair = 0;
    private Seats seats;



    public Flight() {
    }

    public Flight(long number, String source, String destination, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int numberOfTotalSeats) {

        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.numberOfTotalSeats = numberOfTotalSeats;
    }

    public int getNumberOfTotalSeats() {
        return numberOfTotalSeats;
    }

    public void setNumberOfTotalSeats(int numberOfTotalSeats) {
        this.numberOfTotalSeats = numberOfTotalSeats;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public double getTotalFair() {
        return totalFair;
    }

    public void setTotalFair(double totalFair) {
        this.totalFair = totalFair;
    }
}
