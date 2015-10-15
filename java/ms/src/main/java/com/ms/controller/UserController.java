package com.ms.controller;

import com.ms.entity.jpa.User2;
import com.ms.entity.mongodb.User;
import com.ms.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jay on 2015/9/23.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserById")
    private User getUserById(String id){
        User user = null;
        user = userService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "addUser")
    private void addUser(String name){
        User user = new User(name);
        userService.addUser(user);
    }

    @RequestMapping(value = "getUserById2")
    private User2 getUserById2(int id){
        User2 user = null;
        user = userService.getUserByIdJpa(id);
        return user;
    }

}
