package com.everest.airline.utils;

public class FlightException extends RuntimeException{
    private String message;
    protected FlightException() {}

    public FlightException(String message) {
        this.message = message;
    }
}
