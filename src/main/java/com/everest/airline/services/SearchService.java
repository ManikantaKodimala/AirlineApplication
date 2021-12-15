package com.everest.airline.services;

import com.everest.airline.DTO.FlightDTO;
import com.everest.airline.model.Flight;
import com.everest.airline.utils.FlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private PriceStrategyService priceStrategyService;

    @Autowired
    FlightDTO flightDTO;

    public List<Flight> getFlights(String from, String to, String departureDate,String classType, int noOfPassengers) throws Exception {
        List<Flight> result = getFlightsBySourceAndDestination(from, to);
        result = getFlightsByDepartureDate(result, departureDate);
        result = getFLightsByClassType(result,classType,noOfPassengers);
//        result=getFLightsWithAvailableSeats(result);
        if(result.size()==0)
            throw new FlightException("flights ara not available");
        priceStrategyService.updateTotalFaire(result,noOfPassengers,classType);
        return result;
    }

    private List<Flight> getFLightsByClassType(List<Flight> flightList, String classType, int noOfPassengers) {
        return flightList.stream().filter(flight -> flight.getAvailableSeatsOf(classType)>=noOfPassengers).collect(Collectors.toList());
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
                .filter(flight -> departureDate.equals(flight.getDepartureDate()))
                .forEach(flight -> result.add(flight));
        return result;
    }


    public List<Flight> getFlightsBySourceAndDestination(String from, String to) throws Exception {
        return flightDTO.getFlights(from,to);
    }

}
