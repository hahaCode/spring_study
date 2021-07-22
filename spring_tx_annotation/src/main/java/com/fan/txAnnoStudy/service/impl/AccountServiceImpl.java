package com.fan.txAnnoStudy.service.impl;


import com.fan.txAnnoStudy.dao.AccountDao;
import com.fan.txAnnoStudy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)  //也可以加在类上
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void transfer(String inMan, String outMan, double money) {
        accountDao.out(outMan, money);
        accountDao.in(inMan, money);
    }
}
