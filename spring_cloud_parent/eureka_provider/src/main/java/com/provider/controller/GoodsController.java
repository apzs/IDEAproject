package com.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    /**
     * 1.在服务提供方，引入hystrix依赖
     * 2.定义降级方法
     * 3.使用@HystrixCommand注解配置降级方法
     * 4.在启动类上开启Hystrix功能: @EnableCircuitBreaker
     *
     *commandProperties可以配置属性,可以在HystrixCommandProperties类中看所有属性
     */
    @HystrixCommand(fallbackMethod = "findOne_fallBack",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public Goods findOne(@PathVariable("id") int id){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Goods goods = goodsService.findOne(id);
        goods.setTitle(goods.getTitle()+":" + port);
        return goods;
    }

    public Goods findOne_fallBack(int id){
        Goods goods = new Goods(0, "出错了。。。", -1);
        return goods;
    }
}
