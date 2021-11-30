package com.consumer.feign;

import com.consumer.config.FeignLogConfig;
import com.consumer.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 无名氏
 * @date 2021/11/29
 * @Description:
     feign声明式接口。发起远程调用的。
     String url = "http://eureka-provider/goods/find0ne/"+id;
     Goods goods = restTemplate. getForobject(url, Goods.class);
     1.定义接口.
     2.接口上添加注解@FeignClient,设置value属性为服务提供者的应用名称
     会自动注册到容器中

configuration:
     *1.配置文件配置logging.level
     *2.启动类添加@EnableFeignClients
     *3.将Logger.Level添加到容器(FeignLogConfig设置了日志级别)
     *4.@FeignClient 添加configuration属性
fallback:
     降级策略
 */
@FeignClient(value = "EUREKA-PROVIDER",configuration = FeignLogConfig.class,fallback = GoodsFeignClientFallBack.class)
public interface GoodsFeignClient {
     /**
      * 方法名可以和provider的方法名不一样
      * @param id
      * @return
      */
     @GetMapping("/goods/findOne/{id}")
     public Goods findGoodsById(@PathVariable("id") int id);
}
