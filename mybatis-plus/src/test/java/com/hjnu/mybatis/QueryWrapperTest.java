package com.hjnu.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hjnu.mybatis.mapper.UserMapper;
import com.hjnu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author 无名氏
 * @date 2022/3/5
 * @Description: 条件构造器
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
    public void select3() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = "Jone";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("username","a");
        }
        if(ageBegin != null){
            queryWrapper.ge("age", ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age", ageEnd);
        }
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        List<User> l1 = userMapper.selectList(queryWrapper);
        l1.forEach(System.out::println);
        //=========================================================================\\
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        queryWrapper2.like(StringUtils.isNotBlank(username),"username","a")
                    .ge(ageBegin != null,"age", ageBegin)
                    .le(ageEnd != null,"age", ageEnd);
        List<User> l2 = userMapper.selectList(queryWrapper2);
        l2.forEach(System.out::println);
        //=========================================================================\\
        LambdaQueryWrapper<User> queryWrapper3 = new LambdaQueryWrapper<>();
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (nickname LIKE ? AND age >= ? AND age <= ?)
        queryWrapper3.like(StringUtils.isNotBlank(username),User::getName,"a")
                .ge(ageBegin != null,User::getAge, ageBegin)
                .le(ageEnd != null,User::getAge, ageEnd);
        List<User> l3 = userMapper.selectList(queryWrapper3);
        l3.forEach(System.out::println);
    }

    @Test
    public void select4() {

    }

    @Test
    public void select5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询用户信息的nickname和age字段
        queryWrapper.select("nickname","age");
        //SELECT nickname,age FROM t_user WHERE is_deleted=0
        //{nickname=kd, age=18}
        List<Map<String, Object>> l1 = userMapper.selectMaps(queryWrapper);
        //======使用select("nickname","age")查询的字段中nickname不为nickname as name
        //使用User对象接收时 User中的name字段无法封装,为==> 'null'
        //User{id=null, name='null', age=18, email='null', isDeleted=null}
        List<User> l2 = userMapper.selectList(queryWrapper);
        l1.forEach(System.out::println);
        l2.forEach(System.out::println);
        //===================================================================\\
        //上述问题的解决方式为"nickname"改为"nickname as name"
        //该参数也可以用 distinct(distinct nickname as name)等等
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        //查询用户信息的nickname和age字段
        //SELECT nickname as name,age FROM t_user WHERE is_deleted=0
        queryWrapper2.select("nickname as name","age");
        List<User> l3 = userMapper.selectList(queryWrapper2);
        l3.forEach(System.out::println);

    }

    @Test
    public void select6(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //子查询:查询uid<5的数据
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user
        // WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid <20))
        queryWrapper.inSql("uid","select uid from t_user where uid <5");
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
        int i = userMapper.update(new User(20L, "QueryWrapperTest.update", 18, "eww"), updateWrapper);
        System.out.println(i);
    }

    @Test
    public void update2(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET nickname=?, age=?, email=? WHERE is_deleted=0 AND (nickname LIKE ? AND (age > ? OR email IS NULL))
        updateWrapper.like("nickname","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        //id不会被修改
        int i1 = userMapper.update(new User(21L, "QueryWrapperTest.update2.1", 18, "eww"), updateWrapper);
        System.out.println(i1);
        //================================================================================================\\
        UpdateWrapper<User> updateWrapper2 = new UpdateWrapper<>();
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET nickname=?,age=?,email=? WHERE is_deleted=0 AND (nickname LIKE ? AND (age > ? OR email IS NULL))
        updateWrapper2.set("nickname","QueryWrapperTest.update2.2")
                .set("age","18")
                .set("email","wew")
                .like("nickname","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        int i2 = userMapper.update(null, updateWrapper2);
        System.out.println(i2);
        //================================================================================================\\
        LambdaUpdateWrapper<User> updateWrapper3 = new LambdaUpdateWrapper<>();
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET nickname=?,age=?,email=? WHERE is_deleted=0 AND (nickname LIKE ? AND (age > ? OR email IS NULL))
        updateWrapper3.set(User::getName,"QueryWrapperTest.update2.3")
                .set(User::getAge,"18")
                .set(User::getEmail,"wew")
                .like(User::getName,"a")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        int i3 = userMapper.update(null, updateWrapper3);
        System.out.println(i2);
    }

}
