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
     * 1.execution.isolation.thread.timeoutInMilliseconds 超时时间(默认1s)
     * Hystrix熔断机制，用于监控微服务调用情况，当失败的情况达到预定的阈值(5秒失败20次)，会打开断路器，拒绝所有请求，直到服务恢复正常为止。
     * 2.circuitBreaker.sleepWindowInMilliseconds:监控时间(默认5s)
     * 3.circuitBreaker.requestVolumeThreshold:失败次数(默认20次)
     * 4.circuitBreaker.errorThresholdPercentage:失败率(默认50%)
     */
    @HystrixCommand(fallbackMethod = "findOne_fallBack",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "20"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })
    public Goods findOne(@PathVariable("id") int id){

        Goods goods = goodsService.findOne(id);
        goods.setTitle(goods.getTitle()+":" + port);
        return goods;
    }

    public Goods findOne_fallBack(int id){
        Goods goods = new Goods(0, "provider降级了。。。", -1);
        return goods;
    }
}
