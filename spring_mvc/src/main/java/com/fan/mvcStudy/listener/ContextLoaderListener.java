package com.fan.mvcStudy.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //将Spring容器的应用上下文对象app存储到ServletContext域中
        ServletContext servletContext = sce.getServletContext();
        //读取web.xml的全局配置参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        servletContext.setAttribute("app", app);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

//https://www.bilibili.com/video/BV1WZ4y1P7Bp?p=41&spm_id_from=pageDriver