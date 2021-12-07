package com.everest.airline.controllers;

import com.everest.airline.model.Flight;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, String departureDate, Model model) throws IOException {
        List<Flight> searchData = searchService.getFlights(from, to,departureDate);
        model.addAttribute("flights", searchData);
        searchService.updateFlightData(searchData);
        return "search";
    }
}
