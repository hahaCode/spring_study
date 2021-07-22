package com.fan.springstudy.service.impl;

import com.fan.springstudy.dao.UserDao;
import com.fan.springstudy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    //这种写法有问题
    //    @Override
//    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) app.getBean("userDao");
//        userDao.save();
//    }

    // 依赖注入: 1.set方法注入
//    private UserDao userDao;
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    public void save() {
//        userDao.save();
//    }

    // 依赖注入: 2.构造方法注入
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
