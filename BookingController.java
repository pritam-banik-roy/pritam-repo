package com.flightreservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookingController {

    @GetMapping("/book/{id}")
    public String bookFlight(@PathVariable("id") Long id, HttpSession session) {

        // Check if user is logged in
        Object user = session.getAttribute("loggedUser");

        if (user == null) {
            // If not logged in → redirect to login page
            return "redirect:/login";
        }

        // Booking logic will be added later

        return "redirect:/";
    }
}
