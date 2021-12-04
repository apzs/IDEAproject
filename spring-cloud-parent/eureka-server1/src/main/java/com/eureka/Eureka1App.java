package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 无名氏
 * @date 2021/11/28
 * @Description: TODO
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka1App {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1App.class,args);
    }
}
