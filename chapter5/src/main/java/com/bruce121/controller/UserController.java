package com.bruce121.controller;

import com.bruce121.entity.User;
import com.bruce121.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Bruce121
 * Date: 2018-10-31
 */
@RestController
public class UserController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user", method = {RequestMethod.POST})
    public String saveUser(@RequestBody User user){
        return userService.save(user) ? SUCCESS : FAIL;
    }

    @RequestMapping(path = "/user/{id}", method = {RequestMethod.GET})
    public User getByJdbc(@PathVariable("id") long id){
        return userService.get(id);
    }

    @RequestMapping(path = "/get/{id}", method = {RequestMethod.GET})
    public User getById(@PathVariable("id") long id){
        return userService.getByOriginal(id);
    }

    @RequestMapping(path = "/user", method = {RequestMethod.PUT})
    public String updateUser(@RequestBody User user){
        return userService.update(user) ? SUCCESS : FAIL;
    }

    @RequestMapping(path = "/user/{id}", method = {RequestMethod.DELETE})
    public String deleteUser(@PathVariable Long id){
        return userService.delete(id) ? SUCCESS : FAIL;
    }

}