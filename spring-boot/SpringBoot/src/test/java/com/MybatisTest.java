package com;

import com.domain.User;
import com.mapper.UserMapper;
import com.mapper.UserXmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void test(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test2(){
        List<User> userList = userXmlMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
