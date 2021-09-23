package com.test;

import com.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 无名氏
 * @date 2021/9/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringAnnotationTest {

    @Test
    public void test1(){


        ApplicationContext ac = new AnnotationConfigApplicationContext("com.config");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        jdbcTemplate.update("insert into spring_advanced.account(name,money) values(?,?)","lisa",1000);
    }
}
