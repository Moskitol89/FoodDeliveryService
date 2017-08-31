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

    private final FoodDao FOODDAO;

    @Autowired
    public FoodServiceImpl(FoodDao foodDao) {
        this.FOODDAO = foodDao;
    }

    public List<Food> findAll() {
        return FOODDAO.findAll();
    }

    public Food findById(int id) {
        return FOODDAO.findById(id);
    }

    public void save(Food food) {
        FOODDAO.save(food);
    }

    public void delete(int id) { FOODDAO.delete(id);}
}
