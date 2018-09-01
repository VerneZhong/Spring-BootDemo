package com.example.demo.controller;

import com.example.demo.vo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        if (true) {
            throw new RuntimeException("system error...");
        }
        // 异常页面跳转，必须在thymeleaf页面里有的页面，然后到异常处理类，跳转指定的错误页面
        return "/error";
    }

    @RequestMapping("/ajaxError")
    public String ajaxError() {
        return "/ajaxerror";
    }

    @RequestMapping(value = "/getAjaxError", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getAjaxError() {
        int i = 1 / 0;
        return JsonResult.build("ok");
    }
}
