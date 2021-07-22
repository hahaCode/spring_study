package com.fan.annotationStudy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//标识该类为Spring的核心配置文件
@Configuration

//<context:component-scan base-package="com.fan.annotationStudy"/>
@ComponentScan("com.fan.annotationStudy")

//<import resource=""/>   核心配置文件需要引入其他配置文件
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {


}
