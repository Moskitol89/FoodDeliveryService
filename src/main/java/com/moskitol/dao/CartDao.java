package com.moskitol.dao;

import com.moskitol.model.Cart;

import java.util.List;

public interface CartDao {
    List findAll();
    Cart findById(int id);
    void delete(int id);
    void save(Cart basket);
}
