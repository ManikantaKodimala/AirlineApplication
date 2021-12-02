package com.everest.airline;

import com.everest.airline.DTO.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Data {

    public static List<Flight> flights = List.of(
            new Flight(1001, "Hyderabad", "Bangalore"),
            new Flight(1002, "Bangalore", "Hyderabad"),
            new Flight(1003, "Goa", "Bangalore"),
            new Flight(1004, "Bangalore", "Goa"),
            new Flight(1005, "Bangalore", "Hyderabad"),
            new Flight(1006, "Hyderabad", "Bangalore"));
}
