package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    public User getUser() {
        return new User("zxb", "123456", 20, new Date(), "hello zxb");
    }
}
