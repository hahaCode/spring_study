package com.fan.mvcStudy.service.impl;


import com.fan.mvcStudy.dao.UserDao;
import com.fan.mvcStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
