package com.fan.practice.dao;

import com.fan.practice.domain.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    Long save(User user);

    void saveRelationship(Long id, Long[] roleIds);

    void delUserRoleRelationship(Long userId);

    void del(Long userId);

    User findUser(String username, String password);
}
