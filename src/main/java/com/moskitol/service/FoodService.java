package com.moskitol.service;

import com.moskitol.model.Food;
import java.util.List;

public interface FoodService {
    List<Food> findAll();
    Food findById(int id);
    void save(Food food);
    void delete(int id);
}
