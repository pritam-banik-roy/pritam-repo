package com.flightreservation.service;

import com.flightreservation.dao.BookingDAO;
import com.flightreservation.dao.TicketDAO;

import com.flightreservation.model.Booking;
import com.flightreservation.model.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public int createBooking(Booking booking) {

        return bookingDAO.createBooking(booking);
    }

    @Override
    public void createTicket(Passenger passenger, int bookingId) {

        ticketDAO.createTicket(passenger, bookingId);
    }
}
