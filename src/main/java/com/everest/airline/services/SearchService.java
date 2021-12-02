package com.everest.airline.services;

import com.everest.airline.DTO.Flight;
import com.everest.airline.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    public List<Flight> getFlights(String from, String to, String departureDate) {
        List<Flight> result;
        result = getFlightsBySourceAndDestination(from, to);
        System.out.println("flights length"+result.size());
        result = getFlightsByDepartureDate(result, departureDate);
        System.out.println("flights length after date "+result.size());
        result=getFLightsWithAvailableSeats(result);
        return result;
    }

    public List<Flight> getFLightsWithAvailableSeats(List<Flight> flightList) {
        List<Flight> result = new ArrayList<>();
        flightList.stream()
                .filter(flight -> flight.getAvailableSeats()>0)
                .forEach(flight -> result.add(flight));
        return result;
    }

    public List<Flight> getFlightsByDepartureDate(List<Flight> flightList, String departureDate) {
        List<Flight> result = new ArrayList<>();
        flightList.stream()
                .filter(flight ->{
                    System.out.println(departureDate+flight.getDepartureDate()+departureDate.equals(flight.getDepartureDate()));
                    return departureDate.equals(flight.getDepartureDate());
                })
                .forEach(flight -> result.add(flight));
        return result;
    }


    public List<Flight> getFlightsBySourceAndDestination(String from, String to) {
        List<Flight> result = new ArrayList<>();
        Data.flights.stream()
                .filter(flight -> flight.getDestination().equals(to) && flight.getSource().equals(from))
                .forEach(flight -> result.add(flight));
        return result;
    }
}
