package com.everest.airline.controllers;

import com.everest.airline.DTO.FlightDTO;
import com.everest.airline.model.Flight;
import com.everest.airline.services.PriceStrategyService;
import com.everest.airline.utils.FlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private FlightDTO flightDTO;

    @Autowired
    private PriceStrategyService priceStrategyService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from,String to,String departureDate ,String classType,String numberOfPassengers,String todayDate,Model model) throws Exception {
        List<Flight> searchData = flightDTO.getFlights(from, to,departureDate,classType,Integer.parseInt(numberOfPassengers));
        System.out.println("asdfghjkl");
        if(searchData.size()==0)
            throw new FlightException("flights ara not available");
        searchData.stream().forEach(flight -> {
            try {
                priceStrategyService.updateTotalFaire(flight,Integer.parseInt(numberOfPassengers),classType, todayDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        model.addAttribute("flights", searchData);
        model.addAttribute("todayDate",todayDate);
        model.addAttribute("selectedClassType",classType);
        model.addAttribute("numberOfPassengers",numberOfPassengers);
        return "search";
    }
}
