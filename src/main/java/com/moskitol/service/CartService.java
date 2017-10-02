package com.moskitol.service;

import com.moskitol.model.Cart;

import java.util.List;

public interface CartService {
    List findAll();
    Cart findById(int id);
    void delete(int id);
    void save(Cart basket);

}
