package com.fan.mvcStudy.web;

import com.fan.mvcStudy.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //自己写的简易版listener获取ApplicationContext对象
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
//        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = app.getBean(UserService.class);
//        userService.save();


        //用Spring封装好的
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
