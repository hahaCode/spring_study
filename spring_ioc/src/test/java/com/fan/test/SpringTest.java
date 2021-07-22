package com.fan.test;

import com.fan.springstudy.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    /**
     * 测试scope不同的值, 以及对象创建的时间
     *
     */
    @Test
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
    }

    /**
     * singleton取值时, 测试配置 init方法和destroy方法
     */
    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        System.out.println(userDao);

        //手动关闭, 为了看到销毁方法的打印结果
        ((ClassPathXmlApplicationContext)app).close();
    }

    /**
     * 工厂静态方法实例化
     * 工厂实例方法实例化
     */
    @Test
    public void test3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDaoFactory");
        System.out.println(userDao);
    }


}
