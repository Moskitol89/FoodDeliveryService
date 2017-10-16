package com.moskitol.controllers;

import com.moskitol.model.Cart;
import com.moskitol.model.Food;
import com.moskitol.model.User;
import com.moskitol.service.FoodService;
import com.moskitol.service.CartService;
import com.moskitol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EnableWebMvc
@Controller
@SessionAttributes("cart")
public class FoodController {

    private final FoodService FOODSERVICE;
    private final CartService CARTSERVICE;
    private final UserService UsERSERVICE;

    @Autowired
    public FoodController(FoodService foodservice, CartService cartService, UserService usERSERVICE) {
        FOODSERVICE = foodservice;
        CARTSERVICE = cartService;
        UsERSERVICE = usERSERVICE;
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
    //order
    @RequestMapping(value = "/shop/all", method = RequestMethod.GET)
    public ModelAndView shopFoodList(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("shop/allGoods");
        List<Food> foodList = FOODSERVICE.findAll();
        session.setAttribute("cart", new Cart());
        modelAndView.addObject("foodList", foodList);
        return modelAndView;
    }

    @RequestMapping(value = "/shop/all", method = RequestMethod.POST)
    public ModelAndView addToCart(HttpSession session, @RequestParam String foodId) {
        ModelAndView modelAndView = new ModelAndView("shop/allGoods");
        Cart cart = (Cart)session.getAttribute("cart");
        cart.addFood(FOODSERVICE.findById(Integer.parseInt(foodId)));
        modelAndView.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        modelAndView.addObject("msg", cart.getId() + " " + cart.getFoods());
        List<Food> foodList = FOODSERVICE.findAll();
        modelAndView.addObject("foodList", foodList);
        return modelAndView;
    }

    @RequestMapping(value = "/shop/order", method = RequestMethod.GET)
    public ModelAndView orderGet(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("shop/order");
        Cart cart = (Cart)session.getAttribute("cart");
        Set<Food> foodSet = cart.getFoods();
        modelAndView.addObject("foodSet",foodSet);
        return modelAndView;
    }

    @RequestMapping(value = "/shop/order", method = RequestMethod.POST)
    public ModelAndView orderPost(HttpSession session, @RequestParam String foodId) {
        ModelAndView modelAndView = new ModelAndView("shop/order");
        Cart cart = (Cart)session.getAttribute("cart");
        Food foodForDelete = FOODSERVICE.findById(Integer.parseInt(foodId));
        cart.removeFood(foodForDelete);
        Set<Food> foodSet = cart.getFoods();
        modelAndView.addObject("foodSet",foodSet);
        modelAndView.addObject("msg",foodForDelete.getName() +
                " deleted from your shopping cart.");
        return modelAndView;
    }

    @RequestMapping(value = "/shop/confirm", method = RequestMethod.GET)
    public ModelAndView confirmPurchase(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("shop/confirm");
        User user = UsERSERVICE.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Cart cart = (Cart) session.getAttribute("cart");
        Set<Food> foodSet = cart.getFoods();
        float total = 0;
        for(Food foodFromCart : foodSet) {
            total += foodFromCart.getCost();
        }
        String totalPrice = String.format("%.2f", total);
        modelAndView.addObject("user", user);
        modelAndView.addObject("foodSet", foodSet);
        modelAndView.addObject("totalPrice",totalPrice);
        return modelAndView;
    }
    //TODO save order in db
    @RequestMapping(value = "/shop/confirm", method = RequestMethod.POST)
    public ModelAndView confirmed(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("shop/confirmed");
        User user = UsERSERVICE.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Cart cart = (Cart) session.getAttribute("cart");
        modelAndView.addObject("msg", user.getUsername() +
                " ,your order confirmed! Please expect delivery (no). Thank for using my service.");
        return modelAndView;
    }
}
