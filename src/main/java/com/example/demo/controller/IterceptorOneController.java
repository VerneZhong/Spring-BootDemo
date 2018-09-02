package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/one")
public class IterceptorOneController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "zxb");
        return "/index.html";
    }
}
