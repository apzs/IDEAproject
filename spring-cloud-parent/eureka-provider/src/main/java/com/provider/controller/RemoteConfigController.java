package com.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 无名氏
 * @date 2021/12/4
 * @Description: 通过config-server模块访问远程创库的配置文件(内容为user: zhangsan)
 * *config server:
 *  *  1.使用gitee创建远程仓库，上传配置文件
 *  *  2.搭建config server模块
 *  *  3.导入config-server依赖
 *  *  4.编写配置,设置gitee远程仓库地址
 *  *  5.测试访问远程配置文件
 * *config client:(写在eureka-provider)
 *  *  1.导入starter-config依赖
 *  *  2.配置config server地址，读取配置文件名称等信息
 *  *  3.获取配置值
 *  *
 * (使用config-server的http://localhost:8888/master/config-dev.yml会自动更新,但config的client不会更新,需要加入以下配置)
 *  * Config客户端刷新
 *  *     1.在config客户端引入actuator依赖
 *  *     2.获取配置信息类上，添加@RefreshScope注解
 *  *     3.添加配置(management.endpoints.web.exposure.include: refresh)
 *  *     4.使用curl工具发送post请求(curl -X POST http://localhost:8000/actuator/refresh)(再次更新还需要发送post请求)
 */
@RestController
@RefreshScope //客户端刷新
public class RemoteConfigController {

    @Value("${user}")
    public String user;

    //http://localhost:8000/getUser
    @GetMapping("/getUser")
    public void getUser(){
        //控制台输出张三
        System.out.println(user);
    }
}
