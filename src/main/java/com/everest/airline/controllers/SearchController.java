package com.everest.airline.controllers;

import com.everest.airline.DTO.BookingDTO;
import com.everest.airline.model.Flight;
import com.everest.airline.services.PriceStrategyService;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private PriceStrategyService priceStrategyService;

    @Autowired
    private BookingDTO bookingDTO;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from,String to,String departureDate ,String classType,String numberOfPassengers,String todayDate,Model model) throws Exception {
        List<Flight> searchData = searchService.getFlights(from, to,departureDate,classType,Integer.parseInt(numberOfPassengers));
        model.addAttribute("selectedClassType",classType);
        model.addAttribute("numberOfPassengers",numberOfPassengers);
        searchData.stream().forEach(flight -> {
            try {
                priceStrategyService.updateTotalFaire(flight,Integer.parseInt(numberOfPassengers),classType, todayDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        model.addAttribute("flights", searchData);
        model.addAttribute("todayDate",todayDate);
        return "search";
    }
}
