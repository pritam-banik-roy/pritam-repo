package com.flightreservation.dao;

import com.flightreservation.model.Booking;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;

@Repository
public class BookingDAOImpl implements BookingDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createBooking(Booking booking) {

        String sql = "INSERT INTO booking (booking_date, journey_date, seats, total_price, status, flight_id, user_id) VALUES (CURRENT_DATE,?,?,?,?,?,?)";

        jdbcTemplate.update(connection -> {

            PreparedStatement ps =
                    connection.prepareStatement(sql, new String[]{"booking_id"});

            ps.setDate(1, java.sql.Date.valueOf(booking.getJourneyDate()));
            ps.setInt(2, booking.getSeats());
            ps.setDouble(3, booking.getTotalPrice());
            ps.setString(4, "CONFIRMED");
            ps.setLong(5, booking.getFlightId());
            ps.setLong(6, booking.getUserId());

            return ps;

        });

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }
}
