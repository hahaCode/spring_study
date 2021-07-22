package com.fan.mvcStudy.dao.impl;

import com.fan.mvcStudy.dao.UserDao;
import org.springframework.stereotype.Repository;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl---->save....");
    }
}
