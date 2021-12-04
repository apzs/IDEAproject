package com;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /*@Test
    public void testSet(){
        redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    public void testGet(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }*/
}
