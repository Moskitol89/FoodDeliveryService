package com.moskitol.dao;

import com.moskitol.model.User;

import java.util.List;

public interface UserDao {
    List findAll();
    User findById(int id);
    void save(User user);
    void delete(int id);
    User findUserByUsername(String username);
}
