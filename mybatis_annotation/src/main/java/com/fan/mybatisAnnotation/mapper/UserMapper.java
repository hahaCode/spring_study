package com.fan.mybatisAnnotation.mapper;


import com.fan.mybatisAnnotation.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id=#{id}")
    public User findById(int id);

    @Insert("insert into user values(#{id}, #{username}, #{password})")
    public void save(User user);

    @Update("update user set username=#{username}, password=#{password} where id=#{id}")
    public void update(User user);

    @Delete("delete form user where id=#{id}")
    public void delete(int id);

    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.fan.mybatisAnnotation.mapper.OrderMapper.findByUserId")
            )
    })
    public List<User> findAllUserWithOrders();
}
