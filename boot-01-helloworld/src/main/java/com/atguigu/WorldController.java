//在主程序包外面,因此没有获得主程序提供的组件
package com.atguigu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {
    @RequestMapping("/w")
    public String handle01(){
        return "World";
    }
}
