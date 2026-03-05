package com.flightreservation.dao;

import com.flightreservation.model.Flight;
import java.util.List;

public interface FlightDAO {

    List<Flight> findFlights(String source, String destination);

    Flight getFlightById(int id);
}
