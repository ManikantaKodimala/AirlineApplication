package com.everest.airline.database;

import com.everest.airline.model.Flight;

import java.util.Calendar;
import java.util.List;

public class Data {

    public static List<Flight> flights = List.of(
            new Flight(1001, "Hyderabad", "Bangalore", getDateTime(2021, 12, 2,11,12), getDateTime(2021, 12, 2,11,12),10,10),
            new Flight(1002, "Bangalore", "Hyderabad", getDateTime(2021, 12, 3,1,12), getDateTime(2021, 12, 2,11,12),10,1),
            new Flight(1003, "Goa", "Bangalore", getDateTime(2021, 12, 3,12,12), getDateTime(2021, 12, 2,14,12),14,3),
            new Flight(1004, "Bangalore", "Goa", getDateTime(2021, 12, 3,11,12), getDateTime(2021, 12, 2,11,12),14,14),
            new Flight(1005, "Bangalore", "Hyderabad", getDateTime(2021, 12, 3,1,59), getDateTime(2021, 12, 2,11,12),14,0),
            new Flight(1006, "Hyderabad", "Bangalore", getDateTime(2021, 12, 5,1,59), getDateTime(2021, 12, 2,11,12),14,0));

    private static Calendar getDateTime(int year, int month, int date, int hoursOfDay, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year , month-1, date,hoursOfDay,minutes);
        return calendar;
    }

}
