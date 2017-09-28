package com.moskitol.service;

import com.moskitol.model.ShoppingBasket;

import java.util.List;

public interface ShoppingBasketService {
    List findAll();
    ShoppingBasket findById(int id);
    void delete(int id);
    void save(ShoppingBasket basket);

}
