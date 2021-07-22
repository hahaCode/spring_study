package com.fan.annotationStudy.dao.impl;

import com.fan.annotationStudy.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// <bean id="userDao" class="com.fan.annotationStudy.dao.impl.UserDaoImpl"></bean>

//用注解代替上面的配置文件里的配置
//@Component("userDao")

//使用在dao层类上用于实例化bean, 和Component作用一样, 但是可以增加代码可读性
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl---->save....");
    }
}
