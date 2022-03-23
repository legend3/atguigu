package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    //先访问动态，没有动态访问通url的静态
    @RequestMapping("/bug.jpg")
    public String hello() {
        return "aaaa";
    }
}
