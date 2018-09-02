package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器按照顺序执行
        // 拦截所有请求
//        registry.addInterceptor(new InterceptorOne()).addPathPatterns("/*/**");
        registry.addInterceptor(new InterceptorOne()).addPathPatterns("/one/**");
        // 被第一个拦截器就不会执行后面的拦截器了，如果返回false
        registry.addInterceptor(new InterceptorTwo()).addPathPatterns("/one/**").addPathPatterns("/two/**");
        super.addInterceptors(registry);
    }
}
