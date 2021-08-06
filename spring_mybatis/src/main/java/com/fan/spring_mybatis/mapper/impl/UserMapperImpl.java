package com.fan.spring_mybatis.mapper.impl;

import com.fan.spring_mybatis.domain.User;
import com.fan.spring_mybatis.mapper.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapperImpl implements UserMapper {


    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> findAll() {

        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        return users;
    }
}
