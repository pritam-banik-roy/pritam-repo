package com.flightreservation.dao;

import com.flightreservation.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users(email, password, role) VALUES(?,?,?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getRole());
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(User.class),
                email, password);
    }
}
