package com.hjnu.mybatis.plugins;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjnu.mybatis.mapper.UserMapper;
import com.hjnu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 无名氏
 * @date 2022/3/6
 * @Description: 分页插件测试
 */
@SpringBootTest
public class PagePlugins {

    @Autowired
    public UserMapper userMapper;

    /**
     * 1、在配置类中加入 interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
     * 2、使用com.baomidou.mybatisplus.extension.plugins.pagination.Page测试
     */
    @Test
    public void pageTest(){
        Page<User> page = new Page<>(2,5);
        //SELECT COUNT(*) AS total FROM t_user WHERE is_deleted = 0
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 LIMIT ?,?
        userMapper.selectPage(page, null);
        System.out.println("当前页:" + page.getCurrent());
        System.out.println("每页显示的条数:" + page.getSize());
        System.out.println("总记录数:" + page.getTotal());
        System.out.println("总页数:" + page.getPages());
        System.out.println("是否有下一页:" + page.hasNext());
        System.out.println("是否有上一页:" + page.hasPrevious());
    }


    @Test
    public void pageTest2(){
        Page<User> page = new Page<>(1,5);
        //SELECT COUNT(*) AS total FROM t_user WHERE is_deleted = 0
        //SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 LIMIT ?,?
        userMapper.findByPage2(page, 1);
        System.out.println("当前页:" + page.getCurrent());
        System.out.println("每页显示的条数:" + page.getSize());
        System.out.println("总记录数:" + page.getTotal());
        System.out.println("总页数:" + page.getPages());
        System.out.println("是否有下一页:" + page.hasNext());
        System.out.println("是否有上一页:" + page.hasPrevious());
    }

}
