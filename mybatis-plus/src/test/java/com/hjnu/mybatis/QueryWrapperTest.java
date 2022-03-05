package com.hjnu.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hjnu.mybatis.mapper.UserMapper;
import com.hjnu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 无名氏
 * @date 2022/3/5
 * @Description: TODO
 */
@SpringBootTest
public class QueryWrapperTest {

    @Autowired
    public UserMapper userMapper;

    @Test
    public void select() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user
        // WHERE is_deleted=0 AND (nickname LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        queryWrapper.like("nickname", "a")
                .between("age", 20, 30)
                .isNotNull("email");

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void select2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,id ASC
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void delete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //删除email为空的用户
        //DELETE FROM t_user WHERE (email IS NULL) 去除了User类中isDeleted的@TableLogic注解
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        queryWrapper.isNull("email");
        int i = userMapper.delete(queryWrapper);
        System.out.println(i);
    }

    @Test
    public void update() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //UPDATE t_user SET nickname=?, age=?, email=? WHERE is_deleted=0 AND (age > ? AND nickname LIKE ? OR email IS NULL)
        updateWrapper.gt("age", 20)
                     .like("nickname", "a")
                     .or()
                     .isNull("email");
        //id不会被修改
        int i = userMapper.update(new User(20L, "kd", 18, "eww"), updateWrapper);
        System.out.println(i);
    }

    @Test
    public void update2(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        updateWrapper.gt("age", 20)
                .like("nickname", "a")
                .or()
                .isNull("email");
        //id不会被修改
        int i = userMapper.update(new User(20L, "kd", 18, "eww"), updateWrapper);
        System.out.println(i);
    }

    @Test
    public void test(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAge,"20");
    }

}
