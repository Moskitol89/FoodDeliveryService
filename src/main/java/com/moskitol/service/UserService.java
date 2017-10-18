package com.moskitol.service;

import com.moskitol.exceptions.UserNotFoundException;
import com.moskitol.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void delete(int id);
    User findUserByUsername(String username) throws UserNotFoundException;
}
