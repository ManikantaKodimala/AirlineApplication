package com.everest.airline.services;

import com.everest.airline.DTO.Flight;
import com.everest.airline.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    public List<Flight> getFlights(String from, String to) {
        List<Flight> result = new ArrayList<>();
        Data.flights.stream()
                .filter(flight -> flight.getDestination().equals(to) && flight.getSource().equals(from))
                .forEach(flight -> result.add(flight));
        return result;
    }
}
