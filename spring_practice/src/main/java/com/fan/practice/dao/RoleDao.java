package com.fan.practice.dao;

import com.fan.practice.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long userId);
}
