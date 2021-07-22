package com.fan.springstudy.demo;

import com.fan.springstudy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}

//https://www.bilibili.com/video/BV1WZ4y1P7Bp?p=21&spm_id_from=pageDriver