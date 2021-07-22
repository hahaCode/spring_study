package com.fan.mybatisStudy.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 自定义一个类型转换器 实现Date  <---->Long 的转换
 */

public class DateTypeHandler extends BaseTypeHandler<Date> {

    /**
     * 将Java的数据类型转换成数据库中字段存储的类型
     * @param preparedStatement
     * @param i
     * @param date
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        //测试把date转成long
        long time = date.getTime();
        preparedStatement.setLong(i, time);
    }

    /**
     * 将数据库中字段存储的类型转换成JAVA代码所期望的类型
     * @param resultSet
     * @param s  要转换的字段名称
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {

        long time = resultSet.getLong(s);
        Date date = new Date(time);
        return date;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {

        long time = resultSet.getByte(i);
        Date date = new Date(time);
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

        long time = callableStatement.getLong(i);
        Date date = new Date(time);
        return date;
    }
}
