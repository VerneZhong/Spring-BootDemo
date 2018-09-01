package com.example.demo.exception;

import com.example.demo.vo.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
