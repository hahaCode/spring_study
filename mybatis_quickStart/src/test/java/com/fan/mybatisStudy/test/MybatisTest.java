package com.fan.mybatisStudy.test;

import com.fan.mybatisStudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void test1() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象, 会默认开启一个事务, 但事务不会自动提交, 也就意味着需要手动提交该事务, 更新操作数据才会持久化到数据库中
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //openSession(boolean autoCommit)参数为是否自动提交, 如果设置为true, 那么不需要收到提交事务

        //执行操作
        List<User> userList = sqlSession.selectList("userMapper.findAll");//传入 mapper配置的namespace.id

        System.out.println(userList);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作
        sqlSession.insert("userMapper.saveUser", new User("Bob", "987654"));

        //插入操作涉及数据库的数据变化, 而mybatis默认是不自动提交事务的, 所以要使用sqlSession对象显示提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作
        sqlSession.update("userMapper.update", new User(4,"Paul", "888888"));

        //插入操作涉及数据库的数据变化, 而mybatis默认是不自动提交事务的, 所以要使用sqlSession对象显示提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作
        sqlSession.delete("userMapper.deleteUser", 4);

        //插入操作涉及数据库的数据变化, 而mybatis默认是不自动提交事务的, 所以要使用sqlSession对象显示提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象, 会默认开启一个事务, 但事务不会自动提交, 也就意味着需要手动提交该事务, 更新操作数据才会持久化到数据库中
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("userMapper.findById", 1);

        System.out.println(user);

        //释放资源
        sqlSession.close();
    }
}