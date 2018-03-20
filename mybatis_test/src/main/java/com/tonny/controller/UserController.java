package com.tonny.controller;

import com.tonny.dao.UserDao;
import com.tonny.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user")
    private User getUser(@RequestParam int id){
        User user = userDao.selectById(id);
        return user;
    }
}
