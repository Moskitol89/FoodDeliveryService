package com.moskitol.controllers;

import com.moskitol.model.Food;
import com.moskitol.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@Controller
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "/food/foodList")
    public ModelAndView foodList() {
        List<Food> foodList = foodService.findAll();
        ModelAndView modelAndView = new ModelAndView("foodList");
        modelAndView.addObject("foodList",foodList);
        return modelAndView;
    }

    @RequestMapping(value = "/food/add")
    public ModelAndView addFoodPage() {
        ModelAndView modelAndView = new ModelAndView("addFood");
        modelAndView.addObject("food",new Food());
        return modelAndView;
    }

    @RequestMapping(value = "/food/add/process")
    public ModelAndView addFood(@ModelAttribute Food food) {
        ModelAndView modelAndView = new ModelAndView("home");
        foodService.save(food);
        modelAndView.addObject("msg","Food was successfully added : " + food.getName());
        return modelAndView;
    }

    @RequestMapping(value = "/food/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editFoodPage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("editFood");
        Food food = foodService.findById(id);
        modelAndView.addObject("food",food);
        return modelAndView;
    }

    @RequestMapping(value = "/food/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editFood(@ModelAttribute Food food, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        foodService.save(food);
        modelAndView.addObject("msg","Food was successfully edit. id:" + id);
        return modelAndView;
    }

    @RequestMapping(value = "/food/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFood(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        String deletedFoodName = foodService.findById(id).getName();
        foodService.delete(id);
        modelAndView.addObject("msg","Food was successfully deleted: " + deletedFoodName);
        return modelAndView;
    }
}
