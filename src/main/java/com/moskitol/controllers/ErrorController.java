package com.moskitol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping(value = "/errors/403.html")
    public ModelAndView error403(){
        ModelAndView modelAndView = new ModelAndView("/errors/error403");
        modelAndView.addObject("msg","Sorry, access denied or invalid login/password.");
        return modelAndView;
    }
}
