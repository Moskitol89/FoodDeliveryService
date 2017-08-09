package com.moskitol.controllers;

import com.moskitol.model.Food;
import com.moskitol.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@Controller
public class TestController {

    private final FoodService foodService;

    @Autowired
    public TestController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "/foodList.html")
    public ModelAndView foodList() {
        List<Food> foodList = foodService.findAll();
        ModelAndView modelAndView = new ModelAndView("foodList");
        modelAndView.addObject("foodList",foodList);
        return modelAndView;
    }
}
