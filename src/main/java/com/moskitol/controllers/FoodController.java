package com.moskitol.controllers;

import com.moskitol.model.Food;
import com.moskitol.service.FoodService;
import com.moskitol.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final FoodService FOODSERVICE;
    private final CartService CARTSERVICE;

    @Autowired
    public FoodController(FoodService foodservice, CartService cartService) {
        FOODSERVICE = foodservice;
        CARTSERVICE = cartService;
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

    //user

    @RequestMapping(value = "/shop/all", method = RequestMethod.GET)
    public ModelAndView shopFoodList() {
        ModelAndView modelAndView = new ModelAndView("shop/allGoods");
        List<Food> foodList = FOODSERVICE.findAll();
        modelAndView.addObject("foodList", foodList);
        return modelAndView;
    }
    //TODO food to Cart logic. One basket for user's session. add foods to Cart.
}
