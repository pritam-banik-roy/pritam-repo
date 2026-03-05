package com.flightreservation.controller;

import com.flightreservation.model.Passenger;
import com.flightreservation.model.Booking;
import com.flightreservation.model.User;
import com.flightreservation.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class PassengerController {

    @Autowired
    private BookingService bookingService;

    // ===============================
    // LOAD PASSENGER PAGE
    // ===============================

    @GetMapping("/add-passenger")
    public String addPassengerPage(
            @RequestParam int count,
            @RequestParam int flightId,
            Model model) {

        model.addAttribute("passenger", new Passenger());
        model.addAttribute("count", count);
        model.addAttribute("flightId", flightId);
        model.addAttribute("current", 1);

        return "add-passenger";
    }

    // ===============================
    // SAVE PASSENGER
    // ===============================

    @PostMapping("/save-passenger")
    public String savePassenger(
            @ModelAttribute Passenger passenger,
            @RequestParam int count,
            @RequestParam int current,
            @RequestParam int flightId,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("loggedUser");

        // create booking only once
        Booking booking = (Booking) session.getAttribute("booking");

        if (booking == null) {

            booking = new Booking();
            booking.setUserId(user.getUserId());
            booking.setFlightId(flightId);
            booking.setSeats(count);
            booking.setStatus("CONFIRMED");

            int bookingId = bookingService.createBooking(booking);

            booking.setBookingId(bookingId);

            session.setAttribute("booking", booking);
        }

        // save ticket
        bookingService.createTicket(passenger, booking.getBookingId());

        current++;

        // ALL PASSENGERS ADDED
        if (current > count) {

            model.addAttribute("bookingId", booking.getBookingId());

            session.removeAttribute("booking");

            return "booking-confirmation";
        }

        model.addAttribute("passenger", new Passenger());
        model.addAttribute("count", count);
        model.addAttribute("current", current);
        model.addAttribute("flightId", flightId);

        return "add-passenger";
    }
}
