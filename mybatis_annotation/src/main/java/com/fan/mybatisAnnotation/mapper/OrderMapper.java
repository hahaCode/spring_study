package com.fan.mybatisAnnotation.mapper;

import com.fan.mybatisAnnotation.domain.Order;
import com.fan.mybatisAnnotation.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    //一对一查询方式一
//    @Select("select *, o.id oid from orders o, user u where o.uid=u.id")
//    @Results({
//            @Result(column="oid", property="id"),
//            @Result(column="ordertime", property="orderTime"),
//            @Result(column="total", property="total"),
//            @Result(column="uid", property="user.id"),
//            @Result(column="username", property="user.username"),
//            @Result(column="password", property="user.password")
//    })
//    public List<Order> findAll();

    //一对一查询方式二
    @Select("select * from orders")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="ordertime", property="orderTime"),
            @Result(column="total", property="total"),
            @Result(
                    property = "user",  //要封装到order对象的是user属性中
                    javaType = User.class, //要封装的实体类型
                    column = "uid", //根据哪个字段查询user表
                    //一对一查询 select属性表示查询哪个接口的方法获得数据
                    one = @One(select="com.fan.mybatisAnnotation.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();


    @Select("select * from orders where uid=#{uid}")
    public List<Order> findByUserId(int uid);
}
