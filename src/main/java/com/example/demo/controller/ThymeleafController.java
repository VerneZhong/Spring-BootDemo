package com.example.demo.controller;

import com.example.demo.bean.User;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "我是钟学斌，第一次使用thymeleaf模板引擎");
        return "/index.html";
    }

    @RequestMapping("/center")
    public String center() {
        return "/center";
    }

    @RequestMapping("/test")
    public String test(ModelMap modelMap) {
        User u = new User("admin", "123456", 18, new Date(), "test...");
        User u1 = new User("imooc", "123456", 20, new Date(), "test...");
        User u2 = new User("lee", "123456", 26, new Date(), "test...");
        u.setDesc("<font color='green'><b>Hello World</b></font>");
        modelMap.addAttribute("user", u);

        modelMap.addAttribute("userList", Lists.newArrayList(u, u1, u2));
        return "/userInfo";
    }

    @PostMapping("/postform")
    public String postform(User user) {
        System.out.println(user.getName()+"----"+user.getAge());
        return "redirect:/th/test";
    }
}
