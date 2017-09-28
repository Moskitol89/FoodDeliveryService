package com.moskitol.dao;

import com.moskitol.model.ShoppingBasket;

import java.util.List;

public interface ShoppingBasketDao {
    List findAll();
    ShoppingBasket findById(int id);
    void delete(int id);
    void save(ShoppingBasket basket);
}
