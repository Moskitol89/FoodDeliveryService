package com.moskitol.controllers;

import com.moskitol.model.Food;
import com.moskitol.service.FoodService;
import com.moskitol.service.CartService;
import com.moskitol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@Controller
public class FoodController {

    private final FoodService FOODSERVICE;

    @Autowired
    public FoodController(FoodService foodservice) {
        FOODSERVICE = foodservice;
        }


    //admin
    @RequestMapping(value = "/admin/foodList")
    public ModelAndView foodList() {
        List<Food> foodList = FOODSERVICE.findAll();
        ModelAndView modelAndView = new ModelAndView("admin/foodList");
        modelAndView.addObject("foodList", foodList);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/add")
    public ModelAndView addFoodPage() {
        ModelAndView modelAndView = new ModelAndView("admin/addFood");
        modelAndView.addObject("food", new Food());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/add/process")
    public ModelAndView addFood(@ModelAttribute Food food) {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        FOODSERVICE.save(food);
        modelAndView.addObject("msg", "Food was successfully added : " + food.getName());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/editFood/{id}", method = RequestMethod.GET)
    public ModelAndView editFoodPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/editFood");
        Food food = FOODSERVICE.findById(id);
        modelAndView.addObject("food", food);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/editFood/{id}", method = RequestMethod.POST)
    public ModelAndView editFood(@ModelAttribute Food food, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        FOODSERVICE.save(food);
        modelAndView.addObject("msg", "Food was successfully edit. id:" + id);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/deleteFood/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFood(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        String deletedFoodName = FOODSERVICE.findById(id).getName();
        FOODSERVICE.delete(id);
        modelAndView.addObject("msg", "Food was successfully deleted: " + deletedFoodName);
        return modelAndView;
    }

}
