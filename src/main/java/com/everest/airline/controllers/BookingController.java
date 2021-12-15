package com.everest.airline.controllers;

import com.everest.airline.DTO.BookingDTO;
import com.everest.airline.DTO.FlightDTO;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.ParseException;

@Controller
public class BookingController {
    @Autowired
    private BookingDTO bookingDTO;
    @Autowired
    private FlightDTO flightDTO;
    @RequestMapping("/bookFlight")
    public String bookTicket(String flightNumber,String numberOfPassengers,String selectedClassType, Model model) throws IOException, ParseException {
        int flightNum=Integer.parseInt(flightNumber);
        Flight bookedFlight=bookingDTO.getFlight(flightNum);
//        String  selectedClassType =  model.getAttribute();
        System.out.println("########"+selectedClassType);
        System.out.println("@@@@@"+numberOfPassengers);
//        int numberOfPassengers = (int) model.asMap().get("numberOfPassengers");
        flightDTO.upDateSeats(bookedFlight,selectedClassType,Integer.parseInt(numberOfPassengers));


        bookingDTO.updateFlightData(bookedFlight);
        return "home";
    }


}
