package com.moskitol.dao;

import com.moskitol.model.Food;

import java.util.List;

public interface FoodDao {
    List<Food> findAll();
    Food findById(int id);
    void save(Food food);
    void delete(int id);
}
