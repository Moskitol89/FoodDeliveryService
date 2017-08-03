package com.moskitol;

import java.util.List;

public interface FoodDao {
    List<Food> findAll();
    Food findById(int id);
    Food save(Food food);
    void delete(Food food);
}
