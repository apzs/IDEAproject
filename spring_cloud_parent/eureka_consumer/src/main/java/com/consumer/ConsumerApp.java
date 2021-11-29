package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: TODO
 */
@EnableDiscoveryClient  //激活discoveryClient对象
@EnableEurekaClient
@SpringBootApplication
/**
 * 配置负载均衡策略(两种方法:加入bean或配置文件配置)
 * name:服务提供方应用名称
 */
//@RibbonClient(name = "EUREKA-PROVIDER",configuration = MyRule.class)
public class ConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
}
