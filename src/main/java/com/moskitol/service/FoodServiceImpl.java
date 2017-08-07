package com.moskitol.service;

import com.moskitol.dao.FoodDao;
import com.moskitol.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("foodService")
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodDao foodDao;

    @Autowired
    public FoodServiceImpl(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public List<Food> findAll() {
        return foodDao.findAll();
    }

    public Food findById(int id) {
        return null;
    }

    public Food save(Food food) {
        return null;
    }

    public void delete(Food food) {

    }
}
