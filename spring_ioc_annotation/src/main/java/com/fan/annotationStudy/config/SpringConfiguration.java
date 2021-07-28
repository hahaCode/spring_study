package com.fan.annotationStudy.config;

import com.fan.annotationStudy.customer.CustomerBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//标识该类为Spring的核心配置文件

/*
  它是在Spring3.0版本之后加入的, 此注解是spring支持注解开发的一个标志。表明当前类是spring的一个配置类,
  作用是代替applicationContext.xml，但本质实际上就是@Component注解, 被此注解修饰的类也会被存入spring的ioc容器

  在注解驱动开发时, 用于编写配置的类, 通常可以使用此注解. 一般情况下, 我们的配置也会分为主从配置, @Configuration一般会
  出现在主配置类上.

  如果我们使用注解开发时, 构建ioc容器使用的是传入字节码的构造函数, 此注解可以省略, 但如果传入的是一个包, 此注解不可省略
 */
@Configuration

//<context:component-scan base-package="com.fan.annotationStudy"/>
@ComponentScan(value = "com.fan.annotationStudy")
//测试自定义BeanName生成器
//@ComponentScan(value = "com.fan.annotationStudy", nameGenerator = CustomerBeanNameGenerator.class)

//<import resource=""/>   核心配置文件需要引入其他配置文件
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {
}
