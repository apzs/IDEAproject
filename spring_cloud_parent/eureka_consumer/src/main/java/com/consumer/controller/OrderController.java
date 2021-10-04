package com.consumer.controller;

import com.consumer.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    /**需要在启动类激活discoveryClient对象*/
    @Autowired
    private DiscoveryClient discoveryClient;

    //http://localhost:9000/order/goods/1
    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id") int id){
        //远程调用Goods服务中的findOne接口
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka_provider");
        if (instances==null || instances.size()==0){
            return null;
        }
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://" + host+":" +port+" /goods/findOne/"+id;
        Goods goods = restTemplate.getForObject(url, Goods.class);
        return goods;
    }
}
