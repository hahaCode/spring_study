package com.fan.springstudy.dao.impl;

import com.fan.springstudy.dao.UserDao;
import com.fan.springstudy.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

//    public UserDaoImpl() {
//        System.out.println("UserDaoImpl被创建了....");
//    }
//
//    public void init() {
//        System.out.println("init....");
//    }
//
//    public void destroy() {
//        System.out.println("destroy....");
//    }

    public void save() {
        System.out.println("save....");
        System.out.println(stringList);
        System.out.println(userMap);
        System.out.println(properties);
    }
}
