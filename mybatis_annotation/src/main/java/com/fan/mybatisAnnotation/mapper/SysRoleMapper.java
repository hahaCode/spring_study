package com.fan.mybatisAnnotation.mapper;

import com.fan.mybatisAnnotation.domain.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper {

    @Select("select * from sys_user_role ur, sys_role r where r.id=ur.roleId and ur.userId=#{uid}")
    public List<SysRole> findByUserId(int uid);
}
