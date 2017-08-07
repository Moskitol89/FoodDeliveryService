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

    @RequestMapping(value = "/welcome")
    public ModelAndView welcomePage() {
        ModelAndView modelAndView = new ModelAndView("WelcomePage");
        modelAndView.addObject("msg", "Welcome to first test page! just text for commit");
        List<Food> foodList = foodService.findAll();
        modelAndView.addObject("foodList",foodList);
        modelAndView.addObject("food1Name",foodList.get(0).getName());
        return modelAndView;
    }
}
