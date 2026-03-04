package com.flightreservation.dao;

import com.flightreservation.model.User;

public interface UserDAO {

    void save(User user);

    User findByEmailAndPassword(String email,String password);

    User findByEmail(String email);
}
