package com.everest.airline.utils;

public class FlightException extends RuntimeException{
    private String message;
    protected FlightException() {}

    public FlightException(String message) {
        System.out.println("constructor "+message);
        this.message = message;
    }
}
