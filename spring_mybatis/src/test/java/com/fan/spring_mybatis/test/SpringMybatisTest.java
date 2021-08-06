package com.fan.spring_mybatis.test;

import com.fan.spring_mybatis.domain.User;
import com.fan.spring_mybatis.mapper.UserMapper;
import com.fan.spring_mybatis.mapper.impl.UserMapperImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class SpringMybatisTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapperImpl.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
