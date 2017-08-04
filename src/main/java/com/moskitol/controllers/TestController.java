package com.moskitol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
public class TestController {
    @RequestMapping("/welcome")
    public ModelAndView welcomePage() {
        ModelAndView modelAndView = new ModelAndView("WelcomePage");
        modelAndView.addObject("msg", "Welcome to first test page");
        return modelAndView;
    }
}
