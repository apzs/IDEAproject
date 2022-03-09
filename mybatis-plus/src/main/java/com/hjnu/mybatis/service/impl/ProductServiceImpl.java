package com.hjnu.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjnu.mybatis.mapper.ProductMapper;
import com.hjnu.mybatis.pojo.Product;
import com.hjnu.mybatis.service.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author 无名氏
 * @date 2022/3/3
 * @Description: TODO
 */
@Service
@Profile("test")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
