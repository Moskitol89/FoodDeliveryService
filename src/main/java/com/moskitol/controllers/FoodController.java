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
import java.util.HashMap;
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
    public ModelAndView addFood(MultipartHttpServletRequest request, @ModelAttribute Food food) {
        ModelAndView modelAndView = new ModelAndView("admin/home");

        // Message - "message", image title - "imageTitle"
        Map<String,String> mapWithMsgAndImgTitle = fileUpload(request);
        food.setImageTitle(mapWithMsgAndImgTitle.get("imageTitle"));
        food.setDescription(descriptionToHtmlFormat(food.getDescription()));
        FOODSERVICE.save(food);
        modelAndView.addObject("msg", "Food was successfully added : " + food.getName() +
        ". <br> About file: " + mapWithMsgAndImgTitle.get("message")) ;
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


        // Message - "message", image title - "imageTitle"
        Map<String,String> mapWithMsgAndImgTitle = fileUpload(request);

        food.setImageTitle(mapWithMsgAndImgTitle.get("imageTitle"));
        String description = descriptionToHtmlFormat(food.getDescription());

        food.setDescription(description);
        FOODSERVICE.save(food);
        modelAndView.addObject("msg", "Food was successfully edit. id:" + id + " . <br> "
                + "About file: " + mapWithMsgAndImgTitle.get("message"));
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
    //saving the picture not to the server, but to the web resources, you may have to change the implementation.
    private Map<String, String> fileUpload(MultipartHttpServletRequest request) {
        String msgAboutFile;
        Map<String,String> map = new HashMap<String, String>();

        //<input type="file" name="file" />
        MultipartFile requestFile = request.getFile("file");

        if (!requestFile.isEmpty()) {
            try {
                String pathForUpload = request.getSession().getServletContext().getRealPath("/web/");
                pathForUpload = pathForUpload.substring(0,pathForUpload.indexOf("out")) + "web/resources/images/";

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
        map.put("message",msgAboutFile);
        map.put("imageTitle",requestFile.getOriginalFilename());
        return map;
    }

    //just replace \r\n for windows and \n for linux to <br>
    private String descriptionToHtmlFormat(String foodDescription) {
        String htmlDescription = foodDescription;
        if(htmlDescription.contains("\r\n")) {
            htmlDescription = htmlDescription.replaceAll("\r\n","<br>");
        } else if(htmlDescription.contains("\n")) {
            htmlDescription = htmlDescription.replaceAll("\n","<br>");
        }
        return htmlDescription;
    }
}
