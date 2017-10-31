package com.moskitol.controllers;

import com.moskitol.model.Food;
import com.moskitol.service.FoodService;
import com.moskitol.service.CartService;
import com.moskitol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    public ModelAndView addFood(@ModelAttribute Food food, @RequestParam Map<String, String> map) {
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
    public ModelAndView editFood(MultipartHttpServletRequest request,
                                               @ModelAttribute Food food, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("admin/home");
        String msgAboutFile;

        //<input type="file" name="file" />
        MultipartFile requestFile = request.getFile("file");

        if (!requestFile.isEmpty()) {
            try {
                String pathForUpload = request.getSession().getServletContext().getRealPath("/web/");
                pathForUpload = pathForUpload.substring(0,pathForUpload.indexOf("out")) + "web/resources/css/images/";

                File fileNew = new File(pathForUpload, requestFile.getOriginalFilename());

                byte[] bytes = requestFile.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileNew));

                stream.write(bytes);
                stream.close();
                msgAboutFile = "file uploaded.";
            } catch (Exception e) {
                msgAboutFile = "file upload failed. " + e.getMessage();
            }
        } else {
            msgAboutFile = "file was empty.";
        }
        food.setImageTitle(requestFile.getOriginalFilename());
        FOODSERVICE.save(food);
        modelAndView.addObject("msg", "Food was successfully edit. id:" + id + " . <br> "
                + "About file: " + msgAboutFile);
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
