package com.moskitol.controllers;

import com.moskitol.exceptions.UserNotFoundException;
import com.moskitol.model.User;
import com.moskitol.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    private final UserService USERSERVICE;

    public UserController(UserService userservice) {
        USERSERVICE = userservice;
    }
    //admin
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
    //registration
    @RequestMapping(value = "/registration")
    public ModelAndView addFoodPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping(value = "/registration/process")
    public ModelAndView registration(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("registrationComplete");
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        USERSERVICE.save(user);
        modelAndView.addObject("msg","User successfully registered : " + user.getUsername());
        return modelAndView;
    }

    //user
    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public ModelAndView CurrentUserProfileEdit() {
        ModelAndView modelAndView = new ModelAndView("currentUserProfileEdit");
        User user;
        try {
            user = USERSERVICE.findUserByUsername(SecurityContextHolder.getContext().
            getAuthentication().getName());
        } catch (UserNotFoundException e) {
            return  errorPageForCatch(e);
        }
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public ModelAndView CurrentUserProfileEditPost(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("home");
        User currentUser;
        try {
            currentUser = USERSERVICE.findUserByUsername(SecurityContextHolder.getContext().
            getAuthentication().getName());
        } catch (UserNotFoundException e) {
            return  errorPageForCatch(e);
        }
        currentUser.setAddress(user.getAddress());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setPassword(user.getPassword());
        currentUser.setPhoneNumber(user.getPhoneNumber());
        USERSERVICE.save(currentUser);
        modelAndView.addObject("msg","User successfully edited : " + currentUser.getUsername());
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
