package com.consumer.controller;

import com.consumer.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: TODO
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //http://localhost:9000/order/goods/1
    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id") int id){
        //远程调用Goods服务中的findOne接口
        String url = "http://localhost:8000/goods/findOne/"+id;
        Goods goods = restTemplate.getForObject(url, Goods.class);
        return goods;
    }
}
