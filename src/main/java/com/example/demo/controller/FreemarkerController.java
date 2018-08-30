package com.example.demo.controller;

import com.example.demo.bean.Resouroce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resouroce resouroce;

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("data", resouroce);
        return "/index";
    }

    @RequestMapping("/center")
    public String center() {
        return "/center";
    }
}
