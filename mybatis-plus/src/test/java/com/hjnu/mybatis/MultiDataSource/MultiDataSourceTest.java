package com.hjnu.mybatis.MultiDataSource;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjnu.mybatis.pojo.Product;
import com.hjnu.mybatis.pojo.User;
import com.hjnu.mybatis.service.ProductService;
import com.hjnu.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 无名氏
 * @date 2022/3/8
 * @Description: 多数据源测试
 */
@SpringBootTest
public class MultiDataSourceTest {

    @Autowired
    public ProductService productService;

    @Autowired
    public UserService userService;

    /**
     * 多数据源配置步骤
     * 1、引入dynamic-datasource-spring-boot-starter坐标
     * 2、配置文件中配置多数据源(在application-test.yml中配置的)
     * 3、在mapper接口类加上@DS("xxx")注解，指定要操作的数据库
     *      若没有加上该注解且dynamic.strict设置为false ==>使用dynamic.primary(默认为master)的数据源
     *      若没有加上该注解且dynamic.strict设置为true  ==>抛出异常
     * 4、测试
     */

    @Test
    public void test(){
        BaseMapper<Product> baseMapper = productService.getBaseMapper();
        //mybatis_plus2数据库
        //SELECT id,name,price,version FROM t_product
        List<Product> list = baseMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void test2(){
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        //mybatis_plus数据库
        //SELECT uid AS id,nickname AS name,age,sex,email,is_deleted FROM t_user WHERE is_deleted=0
        List<User> list = baseMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
