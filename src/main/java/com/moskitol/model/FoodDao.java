package com.moskitol.model;

import com.moskitol.model.Food;

import java.util.List;

public interface FoodDao {
    List<Food> findAll();
    Food findById(int id);
    Food save(Food food);
    void delete(Food food);
}
