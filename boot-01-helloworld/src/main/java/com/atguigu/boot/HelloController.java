package com.atguigu.boot;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@JRebel   收费,真正的热部署
@Slf4j
@RestController
//@ResponseBody
//@Controller
public class HelloController {
    @Autowired
    Car car;

    @RequestMapping("/hello2")
    public String handle01(@RequestParam("name") String name){
        log.info("请求进来了.....");
        return "Hello Spring boot 2!" + "你好," + name;//加中文验证是否有characterEncodingFilter组件
    }

    @RequestMapping("/car")
    public Car car() {
        log.info("请求进来了.....");
        System.out.println(car);
        return car;
    }
}
