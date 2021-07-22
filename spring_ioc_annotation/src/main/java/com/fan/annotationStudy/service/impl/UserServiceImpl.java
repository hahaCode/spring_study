package com.fan.annotationStudy.service.impl;

import com.fan.annotationStudy.dao.UserDao;
import com.fan.annotationStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//<bean id="userService" class="com.fan.annotationStudy.service.impl.UserServiceImpl">
//<property name="userDao" ref="userDao"/>
//</bean>

//@Component("userService")

@Service("userService")
public class UserServiceImpl implements UserService {

    //注入依赖 <property name="userDao" ref="userDao"/>
    @Autowired  //按照数据类型从Spring容器中进行匹配

    //@Qualifier 是按照id值从容器中进行匹配的, 要和@Autowired 结合使用
    //@Qualifier("userDao") //如果spring容器中有多个UserDao类型的bean, 就要指定注入哪个bean
    private UserDao userDao;

    //如果采用xml配置的方式, 用set方法进行注入, 就必须写setter, 如果使用注解注入, 可以省略
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
    }
}
