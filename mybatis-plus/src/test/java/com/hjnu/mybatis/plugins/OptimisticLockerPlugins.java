package com.hjnu.mybatis.plugins;

import com.hjnu.mybatis.mapper.ProductMapper;
import com.hjnu.mybatis.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 无名氏
 * @date 2022/3/7
 * @Description: 乐观锁插件测试
 */
@SpringBootTest
public class OptimisticLockerPlugins {

    @Autowired
    public ProductMapper productMapper;

    /**
     * 乐观锁步骤
     * 1、在MybatisPlusConfiguration添加乐观锁插件==>OptimisticLockerInnerInterceptor()
     * 2、在Product实体类中的版本号字段加入@Version注解
     * 3、先调用select方法，在调用update方法,update方法会自动加入where version=?
     */
    @Test
    public void test(){
        //a用户获取版本号
        Product p1 = productMapper.selectById(1L);
        //b用户获取版本号
        Product p2 = productMapper.selectById(1L);

        p1.setPrice(p1.getPrice()+50);
        //UPDATE t_product SET name=?, price=?, version=? WHERE id=? AND version=?
        int i1 = productMapper.updateById(p1);
        System.out.println(i1);

        p2.setPrice(p1.getPrice()-30);
        //UPDATE t_product SET name=?, price=?, version=? WHERE id=? AND version=?
        int i2 = productMapper.updateById(p2);
        System.out.println(i2);

        Product p3 = productMapper.selectById(1L);
        System.out.println(p3);
    }
}
