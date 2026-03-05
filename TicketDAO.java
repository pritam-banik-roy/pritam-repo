package com.flightreservation.dao;

import com.flightreservation.model.Passenger;

public interface TicketDAO {

    void createTicket(Passenger passenger, int bookingId);
}
