package com.flightreservation.service;

import com.flightreservation.dao.UserDAO;
import com.flightreservation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        userDAO.save(user);
    }

    @Override
    public User login(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password);
    }
}
