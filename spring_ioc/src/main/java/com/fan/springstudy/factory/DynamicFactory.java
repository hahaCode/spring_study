package com.fan.springstudy.factory;

import com.fan.springstudy.dao.UserDao;
import com.fan.springstudy.dao.impl.UserDaoImpl;

public class DynamicFactory {

    public UserDao getUserDao() {
        System.out.println("DynamicFactory....");
        return new UserDaoImpl();
    }
}
