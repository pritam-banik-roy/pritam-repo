package com.flightreservation.dao;

import com.flightreservation.model.User;
import java.util.List;

public interface UserDAO {
    void save(User user);
    User findByEmailAndPassword(String email, String password);
}
