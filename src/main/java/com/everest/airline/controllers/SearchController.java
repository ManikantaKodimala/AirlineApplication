package com.everest.airline.controllers;

import com.everest.airline.DTO.Flight;
import com.everest.airline.Data;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String search(String from, String to, Model model) {
        List<Flight> searchData = searchService.getFlights(from, to);
        model.addAttribute("flights", searchData);
        return "search";
    }
}
