package com.everest.airline.controllers;

import com.everest.airline.DTO.FileHandler;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
public class FlightsApiController {
    @Autowired
    private FileHandler fileHandler;

    @GetMapping("/flights")
    public List<Flight> getAllFlights() throws IOException {
        return fileHandler.readDataFromFolder();
    }

    @GetMapping("/flights/{number}")
    public Flight getAFlight(@PathVariable("number") long number) throws IOException {
        return fileHandler.readFlight(number);
    }

    @PostMapping("/flights")
    public long createAFlight(@RequestBody Flight flight) throws IOException, ParseException {
        return fileHandler.readLastFlight(flight);
    }

    @PutMapping("/flights/{number}")
    public Flight update(@RequestBody Flight flight) throws IOException, ParseException {
        return fileHandler.updateFlight(flight);
    }

    @DeleteMapping("/flights/{number}")
    public boolean deleteFlight(@PathVariable("number") long number) throws IOException {
        return fileHandler.deleteFlight(number);
    }
}
