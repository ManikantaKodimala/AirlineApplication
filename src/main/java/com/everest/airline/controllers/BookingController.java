package com.everest.airline.controllers;

import com.everest.airline.DTO.BookingDTO;
import com.everest.airline.DTO.FlightDTO;
import com.everest.airline.model.Flight;
import com.everest.airline.services.PriceStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.ParseException;

@Controller
public class BookingController {
    @Autowired
    private BookingDTO bookingDTO;
    @Autowired
    private FlightDTO flightDTO;
    @Autowired
    PriceStrategyService priceStrategyService;
    @RequestMapping("/bookFlight")
    public String bookTicket( String flightNumber,String numberOfPassengers,String selectedClassType, String todayDate,Model model) throws IOException, ParseException {
        Flight bookedFlight =flightDTO.getFlightByNumber(Integer.parseInt(flightNumber));
        flightDTO.upDateSeats(bookedFlight,selectedClassType,Integer.parseInt(numberOfPassengers));
        bookingDTO.updateFlightData(bookedFlight);
        priceStrategyService.updateTotalFaire(bookedFlight,Integer.parseInt(numberOfPassengers),selectedClassType,todayDate);
        model.addAttribute("flight",bookedFlight);
        model.addAttribute("selectedClassType",selectedClassType);
        model.addAttribute("numberOfPassengers",numberOfPassengers);
        return "book";
    }
}
