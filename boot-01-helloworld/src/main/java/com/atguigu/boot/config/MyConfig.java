package com.atguigu.boot.config;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * 如果想要给容器中添加组件时，创建一个配置类：MyConfig，用@Configuration标注！
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类MyConfig本身也是组件
 * 3.@Configuration的属性: 代理 bean的方法
 * 全模式Full(proxyBeanMethods = true)、，MyConfig类会在容器中保存代理对象
 * 轻量级模式Lite(proxyBeanMethods = false)，MyConfig类不会在容器中保存代理对象
 * 适合场景:
 *        配置 类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
 *        配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式
 *
 * 4.@Import({User.class, JsonMapper.class})  --又一种注入组件的方式!
 *  给容器中自动创建出这个两个类型的组件,组件默认的名字就是全类名
 *
 *  5.@ImportResource("classpath:beans.xml")导入Spring的配置文件
 *
 *
 */
@Import({User.class, JsonMapper.class})//注入指定组件及第三类组件
//(先)告诉springboot这是一个配置类 相当于 配置文件(beans.xml)，注释优先配置文件！
@Configuration(proxyBeanMethods = true)//(后)@Configuration: 代理(com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$22472065@35e478f)标注bean的方法为组件
//@ConditionalOnBean(name = "tom")//如果没有tom组件user01也不会加入容器中
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:beans.xml")//注入xml文件中的所有组件进入springboot2容器(不注入，容器不知道xml文件是干嘛的！)
@EnableConfigurationProperties(Car.class)//(第二种方式：在配置类中标注放入容器)
//1、开启Car属性配置功能
//2、把这个car这个组件自动注入到容器中
public class MyConfig {
    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
//    @ConditionalOnBean(name = "tom")//如果没有tom组件user01也不会加入容器中
    @Bean//给容器中添加组件，以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01() {
        User user = new User("zhangsan", 18);
        //true: user组件依赖了pet组件
        //
        user.setPet(tomcatPet());//true
        return user;
    }

    @Bean("tom")//不用方法名作为组件名，自定义一个名
    public Pet tomcatPet() {
        return  new Pet("tomcat");
    }
}
