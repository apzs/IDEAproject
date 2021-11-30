package com.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: 启动类
 */
@EnableEurekaClient  //该注解在新版本中可以省略
@SpringBootApplication
@EnableCircuitBreaker //使用Hystrix熔断器
public class ProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class,args);
    }
}
