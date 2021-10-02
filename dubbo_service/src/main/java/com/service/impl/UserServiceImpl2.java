package com.service.impl;

import com.pojo.User;
import org.apache.dubbo.config.annotation.Service;
import service.UserService;

/**
 * @author 无名氏
 * @date 2021/9/29
 * @Description: 服务的提供者
 */

//将这个类提供的方法(服务)对外发布。访问的地址 ip,端口，路径注册到注册中心中
//服务的消费方和服务的提供方同时配置timeout则消费方配置有效(一般timeout配置在提供方,因为服务的提供方能预计数据库查询的时间)
@Service(version = "v2.0")
public class UserServiceImpl2 implements UserService {

    @Override
    public String sayHello(){
        return "Hello dubbo...";
    }

    @Override
    public User findUserById(int id) {
        System.out.println("new version ...");
        User user = new User(1,"lisa","123");
        return user;
    }
}
