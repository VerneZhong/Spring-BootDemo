package com.example.demo.controller;

import com.example.demo.bean.Resouroce;
import com.example.demo.bean.User;
import com.example.demo.common.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Resouroce resouroce;

    @RequestMapping("/getUser")
    public User getUser() {
        return new User("zxb", "123456", 20, new Date(), "hello zxb");
    }

    @RequestMapping("/getResource")
    public String getResource() {
        Resouroce bean = new Resouroce();
        // source  target
        BeanUtils.copyProperties(resouroce, bean);
        bean.setDate(new Date());
        return JsonUtil.getInstance().toJson(bean);
    }
}
