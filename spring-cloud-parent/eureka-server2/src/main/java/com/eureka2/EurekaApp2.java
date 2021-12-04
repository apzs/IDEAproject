package com.eureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: TODO
 */
@SpringBootApplication
//启用eurekaServer
@EnableEurekaServer
public class EurekaApp2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp2.class,args);
    }
}
