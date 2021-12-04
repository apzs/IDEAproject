package com.provider.service;

import com.provider.dao.GoodsDao;
import com.provider.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: TODO
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public Goods findOne(int id){
        return goodsDao.findOne(id);
    }
}
