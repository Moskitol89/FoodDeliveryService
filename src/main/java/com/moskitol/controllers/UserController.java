package com.moskitol.controllers;

import com.moskitol.exceptions.UserNotFoundException;
import com.moskitol.model.Order;
import com.moskitol.model.User;
import com.moskitol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class UserController {

    private final UserService USERSERVICE;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        user.setPassword(USERSERVICE.findById(id).getPassword());
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

    @RequestMapping(value = "/admin/getOrders", method = RequestMethod.POST)
    public ModelAndView getOrderByUsername(@RequestParam String username) {
        ModelAndView modelAndView = new ModelAndView("admin/orderByUsernameResult");
        User user;
        try {
            user = USERSERVICE.findUserByUsername(username);
        }
        catch (UserNotFoundException e) {
            return errorPageForCatch(e);
        }
        Set<Order> orderList = user.getOrders();
        modelAndView.addObject("orderList", orderList);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView getOrderByUsername() {
        return new ModelAndView("admin/orderByUsername");
    }
    //registration
    @RequestMapping(value = "/registration")
    public ModelAndView addFoodPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping(value = "/registration/process")
    public ModelAndView registration(@ModelAttribute User user, @RequestParam Map<String,String> map) {
        ModelAndView modelAndView = new ModelAndView("registrationComplete");
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        //if passwords fields do not match
        if(map.get("password1").equals(map.get("password2")) && map.get("password1").length() > 5
                && user.getUsername().length() > 4){
            user.setPassword(bCryptPasswordEncoder.encode(map.get("password1")));
        }
        else {
            ModelAndView modelPasswordsDoNotMatch = new ModelAndView("registration");
            modelPasswordsDoNotMatch.addObject("msg","Please check the input data. Passwords must match," +
                    " the minimum password length is 6 characters, and the user name is 5." +
                    " Please, try again.");
            return modelPasswordsDoNotMatch;
        }
        USERSERVICE.save(user);
        modelAndView.addObject("msg","User successfully registered : " + user.getUsername() + map.get("password1"));
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
    public ModelAndView CurrentUserProfileEditPost(@ModelAttribute User user,
                                                   @RequestParam Map<String, String> map) {
        ModelAndView modelAndView = new ModelAndView("home");
        User currentUser;
        try {
            currentUser = USERSERVICE.findUserByUsername(SecurityContextHolder.getContext().
            getAuthentication().getName());
        } catch (UserNotFoundException e) {
            return  errorPageForCatch(e);
        }
        if(!bCryptPasswordEncoder.matches(map.get("oldPassword"), currentUser.getPassword()) ||
                (!map.get("password1").equals(map.get("password2"))) ||
                bCryptPasswordEncoder.matches(map.get("password1"), currentUser.getPassword()) ||
                (map.get("password1").length() < 6)
                ) {
            ModelAndView modelPasswordsProblem = new ModelAndView("currentUserProfileEdit");
            modelPasswordsProblem.addObject("msg","Old or new passwords do not match," +
                    "or old password and new equals, or new passwords length less than 6 please, please try again.");
            return modelPasswordsProblem;
        }
        currentUser.setAddress(user.getAddress());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setPassword(bCryptPasswordEncoder.encode(map.get("password1")));
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
