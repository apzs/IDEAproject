package com.hjnu.mybatis;

import com.hjnu.mybatis.pojo.User;
import com.hjnu.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 无名氏
 * @date 2022/3/3
 * @Description: userService测试类
 */
@SpringBootTest
public class ServiceTest {
    @Autowired
    public UserService userService;

    /**
     * 根据id查
     */
    @Test
    public void getById(){
        User user = userService.getById(1L);
        System.out.println(user);
    }

    /**
     * 增加user
     */
    @Test
    public void save() {
        //增加user,如果写了id则不会根据雪花算法生成id
        User u1 = new User(8L, "lisa", 32, "322");
        boolean save = userService.save(u1);
        //System.out.println(save);
        User u2 = new User(0L, "liw", 21, "3eee");
        /*
        if(id==null){  //id为0时也会查表
            INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        }else{
            total = SELECT id,name,age,email FROM user WHERE id=?
            if(total==0){
                INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
            }
        }
         */
        boolean b = userService.saveOrUpdate(u2);
        //批量修改或添加
        //userService.saveOrUpdateBatch(Arrays.asList(u1,u2));
        System.out.println(b);
    }

    /**
     * 根据id修改
     */
    @Test
    public void update(){
        //根据id修改
        User u1 = new User(8L, "lisa", 32, "322");
        boolean b = userService.updateById(u1);
        System.out.println(b);
        //根据id批量修改
        List<User> list = new ArrayList<>();
        list.add(new User(2L,"ee",24,"ww"));
        list.add(new User(3L,"eww",32,"eed"));
        userService.updateBatchById(list);
    }

    @Test
    public void remove(){
        //根据id删除
        User u1 = new User(14L);
        userService.removeById(u1);
        //根据id批量删除
        List<User> list = new ArrayList<>();
        list.add(new User(2L));
        list.add(new User(3L));
        boolean b = userService.removeByIds(list);
        //boolean b = userService.removeBatchByIds(list);
        System.out.println(b);
    }
}
