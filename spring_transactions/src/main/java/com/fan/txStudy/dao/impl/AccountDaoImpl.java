package com.fan.txStudy.dao.impl;

import com.fan.txStudy.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String name, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?", money, name);
    }

    @Override
    public void in(String name, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?", money, name);
    }
}
