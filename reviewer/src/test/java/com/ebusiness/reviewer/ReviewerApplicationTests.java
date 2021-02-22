package com.ebusiness.reviewer;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.db.Session;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ReviewerApplicationTests {

    @Test
    void contextLoads() {
       String str = "123";
        System.out.println(getMD51(str));
    }

    public static String getMD51(String str){

        String md5 = SecureUtil.md5(str);
        return md5;
    }
    @Test
    public static void method(){
        Map map = new HashMap<>();
    }

    Logger logger = LoggerFactory.getLogger(ReviewerApplicationTests.class);
    @Test
    public void loggerTest(){

        logger.trace("trace级别日志");
        logger.debug("debug级别日志");
        logger.info("info级别日志");
        logger.warn("warn级别日志");
        logger.error("error级别日志");
    }

    @Test
    public void method1(){


    }
}
