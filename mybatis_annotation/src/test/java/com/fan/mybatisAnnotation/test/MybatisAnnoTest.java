package com.fan.mybatisAnnotation.test;

import com.fan.mybatisAnnotation.domain.Order;
import com.fan.mybatisAnnotation.domain.SysUser;
import com.fan.mybatisAnnotation.domain.User;
import com.fan.mybatisAnnotation.mapper.OrderMapper;
import com.fan.mybatisAnnotation.mapper.SysUserMapper;
import com.fan.mybatisAnnotation.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {

    private SqlSession sqlSession;
    private UserMapper userMapper;
    private OrderMapper orderMapper;
    private SysUserMapper sysUserMapper;

    @Before
    public void before() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
    }

    @Test
    public void testUserFindAll() {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void testUserFindById(){
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void testOrderFindAll() {
        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void testFindUserAndOrders(){
        List<User> userWithOrders = userMapper.findAllUserWithOrders();
        for (User userWithOrder : userWithOrders) {
            System.out.println(userWithOrder);
        }
    }

    @Test
    public void testFindUserWithRoles(){
        List<SysUser> sysUserWithRoles = sysUserMapper.findUserWithRoles();
        for (SysUser sysUserWithRole : sysUserWithRoles) {
            System.out.println(sysUserWithRole);
        }
    }

    @After
    public void after() {
        sqlSession.close();
    }
}
