package com.flightreservation.dao;

import com.flightreservation.model.Passenger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTicket(Passenger passenger, int bookingId) {

        String sql = "INSERT INTO ticket (passenger_name, gender, age, journey_date, seat_no, booking_id, status) VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,
                passenger.getName(),
                passenger.getGender(),
                passenger.getAge(),
                null,
                "AUTO",
                bookingId,
                "CONFIRMED"
        );
    }
}
