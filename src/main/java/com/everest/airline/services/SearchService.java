package com.everest.airline.srvices;

import com.everest.airline.DTO.Flight;
import com.everest.airline.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    public List<Flight> getFlights(String from,String to){
        List<Flight> result = null;
        for (Flight flight :
                Data.flights) {
            if(flight.getSource()==from && flight.getDestination()==to)
            result.add(flight);
        }
        System.out.println(result);
        return result;
    }
}
