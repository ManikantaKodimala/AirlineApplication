package com.everest.airline.services;

import com.everest.airline.DTO.FlightDTO;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceStrategyService {
    @Autowired
    private FlightDTO flightDTO;

    public void updateTotalFaire(List<Flight> flightList,int numberOfPassengers,String classType){
        flightList.stream().forEach(flight -> flightDTO.calculateTotalFaire(flight,numberOfPassengers,classType));
    }
}
