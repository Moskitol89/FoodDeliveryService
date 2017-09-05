package com.moskitol.controllers;

import com.moskitol.model.User;
import com.moskitol.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
