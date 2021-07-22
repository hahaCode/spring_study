package com.fan.mybatisAnnotation.mapper;

import com.fan.mybatisAnnotation.domain.SysUser;
import com.fan.mybatisAnnotation.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper {

    @Select("select * from sys_user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(
                    column = "id",
                    property = "roleList",
                    javaType = List.class,
                    many = @Many(select = "com.fan.mybatisAnnotation.mapper.SysRoleMapper.findByUserId")
            )
    })
    public List<SysUser> findUserWithRoles();
}
