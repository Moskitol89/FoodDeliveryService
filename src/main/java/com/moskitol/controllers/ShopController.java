package com.moskitol.controllers;

import com.moskitol.exceptions.UserNotFoundException;
import com.moskitol.model.Cart;
import com.moskitol.model.Food;
import com.moskitol.model.Order;
import com.moskitol.model.User;
import com.moskitol.service.CartService;
import com.moskitol.service.FoodService;
import com.moskitol.service.OrderService;
import com.moskitol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class ShopController {

    private final FoodService FOODSERVICE;
    private final UserService USERSERVICE;
    private final CartService CARTSERVICE;
    private final OrderService ORDERSERVICE;

    @Autowired
    public ShopController(FoodService foodservice, UserService userservice,
                          CartService cartservice, OrderService orderservice) {
        FOODSERVICE = foodservice;
        USERSERVICE = userservice;
        CARTSERVICE = cartservice;
        ORDERSERVICE = orderservice;
    }

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
        Food foodToCart = FOODSERVICE.findById(Integer.parseInt(foodId));
        cart.addFood(foodToCart);
        List<Food> foodList = FOODSERVICE.findAll();
        float totalPrice = 0;
        for(Food food : cart.getFoods()) {
            totalPrice += food.getCost();
        }
        modelAndView.addObject("msg",foodToCart.getName() +
                " added to cart. Total price: " + totalPrice);
        modelAndView.addObject("foodList", foodList);
        return modelAndView;
    }

    @RequestMapping(value = "/shop/order", method = RequestMethod.GET)
    public ModelAndView orderGet(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("shop/order");
        Cart cart = (Cart)session.getAttribute("cart");
        Set<Food> foodSet = cart.getFoods();
        float totalPrice = 0;
        for(Food food : foodSet) {
            totalPrice += food.getCost();
        }
        modelAndView.addObject("totalPrice",totalPrice);
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
        float totalPrice = 0;
        for(Food food : foodSet) {
            totalPrice += food.getCost();
        }
        modelAndView.addObject("totalPrice",totalPrice);
        modelAndView.addObject("foodSet",foodSet);
        modelAndView.addObject("msg",foodForDelete.getName() +
                " deleted from your shopping cart.");
        return modelAndView;
    }

    @RequestMapping(value = "/shop/confirm", method = RequestMethod.GET)
    public ModelAndView confirmPurchase(HttpSession session) {
        User user;
        try {
            user = USERSERVICE.findUserByUsername(SecurityContextHolder.getContext().
                    getAuthentication().getName());
        }catch (UserNotFoundException e) {
            return errorPageForCatch(e);
        }
        ModelAndView modelAndView = new ModelAndView("shop/confirm");
        Cart cart = (Cart) session.getAttribute("cart");
        Set<Food> foodSet = cart.getFoods();
        float total = 0;
        for(Food foodFromCart : foodSet) {
            total += foodFromCart.getCost();
        }
        modelAndView.addObject("user", user);
        modelAndView.addObject("foodSet", foodSet);
        modelAndView.addObject("totalPrice",total);
        return modelAndView;
    }

    @RequestMapping(value = "/shop/confirm", method = RequestMethod.POST)
    public ModelAndView confirmed(HttpSession session,@RequestParam String addressTextArea) {
        User user;
        ModelAndView modelAndView = new ModelAndView("shop/confirmed");
        try {
            user = USERSERVICE.findUserByUsername(SecurityContextHolder.getContext().
                    getAuthentication().getName());
        }catch (UserNotFoundException e) {
          return errorPageForCatch(e);
        }
        Cart cart = (Cart) session.getAttribute("cart");
        CARTSERVICE.save(cart);
        Order order = new Order();
        order.setDeliveryAddress(addressTextArea);
        order.setUser(user);
        order.setCart(cart);
        ORDERSERVICE.save(order);
        modelAndView.addObject("msg", user.getUsername() +
                " ,your order confirmed! Please expect delivery (no). Thank for using my service. " +
                "Order id : " + order.getId());
        return modelAndView;
    }
    //method for try-catch
    private ModelAndView errorPageForCatch(Exception e) {
        ModelAndView modelAndViewFromCatch = new ModelAndView("errors/error");
        modelAndViewFromCatch.addObject("msg","Please send send this message" +
                " to the administration : " + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        return modelAndViewFromCatch;
    }
}
