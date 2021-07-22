package com.fan.springstudy.factory;

import com.fan.springstudy.dao.UserDao;
import com.fan.springstudy.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao() {
        System.out.println("StaticFactory....");
        return new UserDaoImpl();
    }
}
