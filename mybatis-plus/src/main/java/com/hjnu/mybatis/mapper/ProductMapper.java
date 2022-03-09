package com.hjnu.mybatis.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjnu.mybatis.pojo.Product;
import org.springframework.stereotype.Repository;

/**
 * @author 无名氏
 * @date 2022/3/7
 * @Description: TODO
 */
@Repository
@DS("slave_1")
public interface ProductMapper extends BaseMapper<Product> {
}
