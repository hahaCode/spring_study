package com.fan.mybatisStudy.dao;

import com.fan.mybatisStudy.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    public List<User> findAll() throws IOException;

    public User findById(int id);

    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);
}

//https://www.bilibili.com/video/BV1WZ4y1P7Bp?p=175&spm_id_from=pageDriver