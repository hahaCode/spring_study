package com.fan.mybatisStudy.test;

import com.fan.mybatisStudy.dao.UserMapper;
import com.fan.mybatisStudy.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ProxyDaoTest {

    @Test
    public void test1() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        System.out.println(userList);

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟不定条件查询
        //User conditionUser = new User(1, "Amy", "123456");
        User conditionUser = new User("Amy", "123456");
        List<User> userList = mapper.findByCondition(conditionUser);
        System.out.println(userList);

        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟ids的list
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);

        sqlSession.close();
    }

    //分页查询
    @Test
    public void test5() throws IOException {
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数, 当前页+每页显示的条数
        PageHelper.startPage(3, 2);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页:" + pageInfo.getPageNum());
        System.out.println("每页显示条数:" + pageInfo.getPageSize());
        System.out.println("总条数:" + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("上一页:" + pageInfo.getPrePage());
        System.out.println("下一页:" + pageInfo.getNextPage());

        sqlSession.close();
    }
}
