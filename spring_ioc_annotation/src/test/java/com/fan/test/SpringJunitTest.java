package com.fan.test;

import com.fan.annotationStudy.config.SpringConfiguration;
import com.fan.annotationStudy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Spring 集成 Junit
 * 1.导入junit 和 spring-test的坐标
 * 2.使用@RunWith注解替换原来的运行期
 * 3.使用@ContextConfiguration指定配置文件或配置类
 * 4.使用@Autowired注入需要测试的对象
 * 5.创建测试方法进行测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
//xml 配置文件方式
//@ContextConfiguration("classpath:applicationContext.xml")

//如果是全注解形式
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Test
    public void test1() throws SQLException {

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        userService.save();
    }
}
