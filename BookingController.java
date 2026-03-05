// package com.flightreservation.controller;

// import javax.servlet.http.HttpSession;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// @Controller
// public class BookingController {

//     @GetMapping("/book/{id}")
//     public String bookFlight(@PathVariable("id") Long id, HttpSession session) {

//         // Check if user is logged in
//         Object user = session.getAttribute("loggedUser");

//         if (user == null) {
//             // If not logged in → redirect to login page
//             return "redirect:/login";
//         }

//         // Booking logic will be added later

//         return "redirect:/";
//     }
// }
=======================================================================================================


    package com.flightreservation.controller;

import com.flightreservation.model.Flight;
import com.flightreservation.model.User;
import com.flightreservation.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class BookingController {

    @Autowired
    private FlightService flightService;

    // ==============================
    // OPEN BOOKING PAGE
    // ==============================

    @GetMapping("/book/{id}")
    public String bookFlight(
            @PathVariable("id") int id,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("loggedUser");

        // USER NOT LOGGED IN
        if (user == null) {

            session.setAttribute("redirectAfterLogin", "/book/" + id);

            return "redirect:/login";
        }

        // FETCH FLIGHT DETAILS
        Flight flight = flightService.getFlightById(id);

        model.addAttribute("flight", flight);

        return "booking-form";
    }
}
