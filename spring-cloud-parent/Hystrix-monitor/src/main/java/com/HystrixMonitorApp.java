package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author 无名氏
 * @date 2021/12/1
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker //启用熔断
@EnableTurbine  //开启Turbine聚合监控功能
@EnableHystrixDashboard //开启Hystrix仪表盘监控功能
public class HystrixMonitorApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMonitorApp.class);
    }
}
