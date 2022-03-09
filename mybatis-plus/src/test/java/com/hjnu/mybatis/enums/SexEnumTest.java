package com.hjnu.mybatis.enums;

import com.hjnu.mybatis.mapper.UserMapper;
import com.hjnu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 无名氏
 * @date 2022/3/8
 * @Description: 通用枚举测试
 */
@SpringBootTest
public class SexEnumTest {

    @Autowired
    public UserMapper userMapper;

    /**
     * 通用枚举步骤
     * 1、添加enum类
     * 2、在数据库中想添加的字段上加@EnumValue注解
     * 3、在配置文件中加入 type-enums-package: com.hjnu.mybatis.enums 配置扫描通用枚举
     * 4、在实体类(User)中sex的类型改为enum类型,数据库中的sex类型为int
     * 5、sexSex设置枚举类型
     */
    @Test
    public void test(){
        User user = new User(null,"fd",21,"dd");
        user.setSex(SexEnum.MAIL);
        //Preparing: INSERT INTO t_user ( nickname, age, sex, email ) VALUES ( ?, ?, ?, ? )
        //Parameters: fd(String), 20(Integer), 1(Integer), dd(String)
        System.out.println(userMapper.insert(user));
    }
}
