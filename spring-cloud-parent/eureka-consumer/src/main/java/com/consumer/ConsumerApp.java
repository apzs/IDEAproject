package com.consumer;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

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
@EnableFeignClients  //开启feign功能
@EnableHystrixDashboard // 开启Hystrix仪表盘监控功能
public class ConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }

    /**
     * 为了使用Hystrix仪表盘监控功能
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
