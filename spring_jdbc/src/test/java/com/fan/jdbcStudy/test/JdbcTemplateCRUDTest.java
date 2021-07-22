package com.fan.jdbcStudy.test;

import com.fan.jdbcStudy.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //改
    @Test
    public void testUpdate() {
        jdbcTemplate.update("update account set money=? where name=?", 10000, "tom");
    }

    //删
    @Test
    public void testDelete() {
        jdbcTemplate.update("delete from account where name=?", "amy");
    }

    //查询全部
    @Test
    public void testQueryAll() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    //查询一条数据
    @Test
    public void testQueryOne() {
        Account amy = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "amy");
        System.out.println(amy);
    }

    //聚合查询
    @Test
    public void testQueryCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
}
