package com.service.impl;

import com.pojo.User;
import org.apache.dubbo.config.annotation.Service;
import service.UserService;

/**
 * @author 无名氏
 * @date 2021/9/29
 * @Description: 服务的提供者
 */

/**
 * @Service 将这个类提供的方法(服务)对外发布。访问的地址 ip,端口，路径注册到注册中心中
 * timeout、服务的消费方和服务的提供方同时配置timeout则消费方配置有效(一般timeout配置在提供方,因为服务的提供方能预计数据库查询的时间)
 * retries、当前服务1秒超时,默认重试其他的服务器2次(一共3次)若没有其他服务器则还访问这一台(一般用于读操作)
            可在Controller的@Reference注解的cluster属性设置集群容错模式
 * version、发布多个版本
            可在Controller的@Reference注解的version属性指定访问的版本
 * weight、 这台机器负载均衡的权值设为100    被访问的几率= 这台机器的权重 / 总权重
            需要在服务消费方Controller的@Reference注解的loadbalance属性指定负载均衡策略
 */
@Service(timeout = 1000,retries = 2,version = "v1.0",weight = 100)
public class UserServiceImpl implements UserService {

    public String sayHello(){
        return "Hello dubbo...";
    }

    public User findUserById(int id) {
        System.out.println("old version ...");
        User user = new User(1,"lisa","123");
        return user;
    }
}
