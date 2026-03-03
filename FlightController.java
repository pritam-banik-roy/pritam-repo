package com.flightreservation.controller;

import com.flightreservation.dao.FlightDAO;
import com.flightreservation.model.Flight;
import com.flightreservation.model.SearchFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightDAO flightDAO;

    // Load Home Page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("searchFlight", new SearchFlight());
        return "home";
    }

    // Search Flights
    @PostMapping("/search")
    public String searchFlights(@ModelAttribute("searchFlight") SearchFlight searchFlight,
                                Model model) {

        List<Flight> flights = flightDAO.findFlights(
                searchFlight.getSource(),
                searchFlight.getDestination()
        );

        model.addAttribute("flights", flights);
        return "home";   // IMPORTANT: return same page
    }
}
