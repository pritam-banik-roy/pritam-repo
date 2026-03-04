package com.flightreservation.dao;

import com.flightreservation.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class FlightDAOImpl implements FlightDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Flight> findFlights(String source, String destination) {

        String sql = "SELECT * FROM flight WHERE LOWER(source)=LOWER(?) AND LOWER(destination)=LOWER(?)";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Flight.class),
                source,
                destination
        );
    }
}
