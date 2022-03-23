package com.atguigu.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件才会拥护springboot提供的强大功能
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component//(第一种方式: 本组件类中标注)放入容器中
@ConfigurationProperties(prefix = "mycar")//关联properties配置文件中的属性值
public class Car {
    private String brand;
    private Integer price;

}
