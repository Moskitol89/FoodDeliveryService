package com.moskitol;

import com.moskitol.model.Food;
import com.moskitol.dao.FoodDao;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Sample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation.xml");
        ctx.refresh();

        FoodDao foodDao = ctx.getBean("foodDao", FoodDao.class);
        listFood(foodDao.findAll());
    }

    private static void listFood(List<Food> foods) {
        System.out.println();
        for(Food food : foods) {
            System.out.println(food);
        }
    }
}
