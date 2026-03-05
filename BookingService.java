package com.flightreservation.service;

import com.flightreservation.model.Booking;
import com.flightreservation.model.Passenger;

public interface BookingService {

    int createBooking(Booking booking);

    void createTicket(Passenger passenger, int bookingId);
}
