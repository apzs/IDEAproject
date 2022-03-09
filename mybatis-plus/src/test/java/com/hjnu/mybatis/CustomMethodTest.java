package com.hjnu.mybatis;

import com.hjnu.mybatis.mapper.UserMapper;
import com.hjnu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 无名氏
 * @date 2022/3/3
 * @Description: 测试自定义方法
 */
@SpringBootTest
public class CustomMethodTest {

    @Autowired
    public UserMapper userMapper;

    @Test
    public void findById(){
        User user = userMapper.findById(1L);
        System.out.println(user);
    }

    @Test
    public void findByAge(){
        List<User> users = userMapper.findByAge(1);
       users.forEach(System.out::println);
    }
}
