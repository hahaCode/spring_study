package com.fan.practice.service.impl;

import com.fan.practice.dao.RoleDao;
import com.fan.practice.dao.UserDao;
import com.fan.practice.domain.Role;
import com.fan.practice.domain.User;
import com.fan.practice.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList的每一个user的roles数据
        for (User user : userList) {
            //获取userid
            Long userId = user.getId();
            //将Id作为参数, 查询当前user对应的Role的集合
            List<Role> roles = roleDao.findRoleByUserId(userId);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);
        userDao.saveRelationship(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
        //删除sys_user_role关系表里的相关数据
        userDao.delUserRoleRelationship(userId);

        //删除sys_user表里的相关数据
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {

        User user = null;

        try {
            user = userDao.findUser(username,password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
