package com.fan.practice.service;

import com.fan.practice.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();

    void save(Role role);
}
