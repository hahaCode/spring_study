package com.fan.mybatisStudy.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

    static Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void test1() {
        logger.info("This is a info message!");
    }
}
