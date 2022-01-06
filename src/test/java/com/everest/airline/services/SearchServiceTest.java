package com.everest.airline.services;

import com.everest.airline.model.Flight;
import com.everest.airline.database.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SearchServiceTest {
    @Autowired
    SearchService searchService;

    @Test
    void testGetFlightsBySourceAndDestination() throws Exception {
        String source="Hyderabad";
        String destination="Bangalore";
        List<Flight> expected =List.of(Data.flights.get(0),Data.flights.get(5));

        List<Flight> actual = searchService.getFlightsBySourceAndDestination(source, destination);

        assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void testGetFlightsByDepartureDate(){
        String departureDate="2021-12-05";
        List<Flight> expected = List.of(Data.flights.get(5));

        List<Flight> actual=searchService.getFlightsByDepartureDate(Data.flights,departureDate);

        assertArrayEquals(expected.toArray(),actual.toArray());
    }

//    @Test
//    void testGetFLightsWithAvailableSeats(){
//        List<Flight> expected = List.of(Data.flights.get(0),Data.flights.get(1),Data.flights.get(2),Data.flights.get(3));
//
//        List<Flight> actual= searchService.getFLightsWithAvailableSeats(Data.flights);
//
//        assertArrayEquals(expected.toArray(),actual.toArray());
//    }
}