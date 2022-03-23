package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
    private String name;
    private Integer age;
}
