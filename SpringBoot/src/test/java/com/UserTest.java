package com;

import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
@RunWith(SpringRunner.class)
//如果测试包与与主包一致或是主包的子包， 就不用写classes = HelloApplication.class
@SpringBootTest(classes = HelloApplication.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void addTest(){
        userService.add();
    }
}
