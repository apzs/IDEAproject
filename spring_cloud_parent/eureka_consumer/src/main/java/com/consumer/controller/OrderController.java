package com.consumer.controller;

import com.consumer.domain.Goods;
import com.consumer.feign.GoodsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    /**需要在启动类激活discoveryClient对象*/
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private GoodsFeignClient goodsFeignClient;

   /* //http://localhost:9000/order/goods/1
    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id") int id){
        //远程调用Goods服务中的findOne接口
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-provider");
        if (instances==null || instances.size()==0){
            return null;
        }
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://" + host+":" +port+" /goods/findOne/"+id;
        Goods goods = restTemplate.getForObject(url, Goods.class);
        return goods;
    }*/

    /**
     * 使用Ribbon 简化restTemplate调用
     * 1.在声明restTemplate的Bean时候，添加一个注解: @LoadBalanced
     * 2.把负载均衡的一个策略类添加到容器(添加在MyRule类)
     * 3.在使用restTemplate发起请求时，需要定义url时，host:port可以替换为服务提供方的应用名称
     * (加@LoadBalanced后findGoodsById方法不能正常访问)
     * @param id
     * @return
     */
    //http://localhost:9000/order/goods2/1
    @GetMapping("/goods2/{id}")
    public Goods findGoodsById2(@PathVariable("id") int id){
        //eureka不支持下划线
        String url = "http://eureka-provider/goods/findOne/"+id;
        Goods goods = restTemplate.getForObject(url, Goods.class);
        return goods;
    }

    @GetMapping("/goods3/{id}")
    public Goods findGoodsById3(@PathVariable("id") int id){
        return goodsFeignClient.findGoodsById(id);
    }
}
