package com.example.demo.exception;

import com.example.demo.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理
 */
@ControllerAdvice
public class ExceptionHandler {

    public static final String ERROR_VIEW = "/error";

    /**
     * 单个异常处理
     */
//    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
//        e.printStackTrace();
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e.getMessage());
//        mav.addObject("url", request.getRequestURL());
//        mav.setViewName(ERROR_VIEW);
//        return mav;
//    }

    /**
     * 统一异常处理
     * @param request
     * @param response
     * @param e
     * @return
     * @throws Exception
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        if (isAjax(request)) {
            return JsonResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e.getMessage());
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 判断是否Ajax请求
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request) {
        return request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
