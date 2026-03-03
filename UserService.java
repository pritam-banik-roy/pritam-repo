package com.flightreservation.service;

import com.flightreservation.model.User;

public interface UserService {

    void register(User user);

    User login(String email, String password);
}
