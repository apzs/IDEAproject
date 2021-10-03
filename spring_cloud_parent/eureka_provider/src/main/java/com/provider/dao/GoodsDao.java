package com.provider.dao;

import com.provider.domain.Goods;
import org.springframework.stereotype.Repository;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: TODO
 */
@Repository
public class GoodsDao {

    public Goods findOne(int id){
        return new Goods(1,"手机",1000);
    }
}
