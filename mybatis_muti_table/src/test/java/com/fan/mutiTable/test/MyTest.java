package com.fan.mutiTable.test;

import com.fan.mutiTable.domain.Order;
import com.fan.mutiTable.domain.SysUser;
import com.fan.mutiTable.domain.User;
import com.fan.mutiTable.mapper.OrderMapper;
import com.fan.mutiTable.mapper.SysUserMapper;
import com.fan.mutiTable.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    //一对多和多对一
    @Test
    public void test1() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> mapperAll = orderMapper.findAll();
        for (Order order : mapperAll) {
            System.out.println(order);
        }

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //多对多
    @Test
    public void test3() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        List<SysUser> userMapperAll = sysUserMapper.findAll();
        for (SysUser sysUser : userMapperAll) {
            System.out.println(sysUser);
        }

        sqlSession.close();
    }
}
