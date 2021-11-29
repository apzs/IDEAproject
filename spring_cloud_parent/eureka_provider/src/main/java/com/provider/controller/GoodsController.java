package com.provider.controller;

import com.provider.domain.Goods;
import com.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: TODO
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Value("${server.port}")
    private String port;

    //http://localhost:8000/goods/findOne/1
    @GetMapping("/findOne/{id}")
    public Goods findOne(@PathVariable("id") int id){
        Goods goods = goodsService.findOne(id);
        goods.setTitle(goods.getTitle()+":" + port);
        return goods;
    }
}
