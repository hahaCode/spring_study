package com.fan.annotationStudy.web;

import com.fan.annotationStudy.config.SpringConfiguration;
import com.fan.annotationStudy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = app.getBean(UserService.class);
//        userService.save();

        //注解形式这样加载
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}

//https://www.bilibili.com/video/BV1WZ4y1P7Bp?p=30&spm_id_from=pageDriver