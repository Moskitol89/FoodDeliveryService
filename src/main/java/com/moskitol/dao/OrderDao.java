package com.moskitol.dao;

import com.moskitol.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();
    Order findById(int id);
    void save(Order order);
    void delete(int id);
}
