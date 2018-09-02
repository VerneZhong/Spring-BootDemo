package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
//扫描mybatis mapper 包路径
@MapperScan(basePackages = "com.example.demo.mapper")
//扫描所需的包，包含一些自用的工具类包，所在路径
@ComponentScan(basePackages = {"com.example"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("系统启动");
    }

    @PreDestroy
    public void exitSystem() {
        System.out.println("系统关闭");
    }
}
