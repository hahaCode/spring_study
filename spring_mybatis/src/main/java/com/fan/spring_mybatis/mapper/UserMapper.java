package com.fan.spring_mybatis.mapper;

import com.fan.spring_mybatis.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
}
