package com;

import com.consumer.ConsumerApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 无名氏
 * @date 2021/12/1
 * @Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApp.class)
public class feignTest {

    @Autowired
    private Environment environment;

    @Test
    public void test(){
        System.out.println();
        System.out.println();
        System.out.println(environment.getProperty("feign.client.config.default.connectTimeout"));
        System.out.println();
        System.out.println();
    }

}
