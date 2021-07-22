package com.fan.txAnnoStudy.dao.impl;


import com.fan.txAnnoStudy.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String name, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?", money, name);
    }

    @Override
    public void in(String name, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?", money, name);
    }
}
