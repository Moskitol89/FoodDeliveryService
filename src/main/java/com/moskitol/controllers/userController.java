package com.moskitol.controllers;

import com.moskitol.model.Food;
import com.moskitol.model.User;
import com.moskitol.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class userController {

    private final UserService USERSERVICE;

    public userController(UserService userservice) {
        USERSERVICE = userservice;
    }

    @RequestMapping(value = "/admin/userList")
    public ModelAndView userList(){
        List<User> users = USERSERVICE.findAll();
        ModelAndView modelAndView = new ModelAndView("admin/userList");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView editFoodPage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/editUser");
        User user = USERSERVICE.findById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/editUser/{id}", method = RequestMethod.POST)
    public ModelAndView editFood(@ModelAttribute User user, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        USERSERVICE.save(user);
        modelAndView.addObject("msg","User was successfully edit. username:" + user.getUsername());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFood(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        String deletedUsername = USERSERVICE.findById(id).getUsername();
        USERSERVICE.delete(id);
        modelAndView.addObject("msg","User was successfully deleted: " + deletedUsername);
        return modelAndView;
    }
}
