package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 无名氏
 * @date 2021/12/4
 * @Description:
 *config server:
 *  1.使用gitee创建远程仓库，上传配置文件
 *  2.搭建config server模块
 *  3.导入config-server依赖
 *  4.编写配置,设置gitee远程仓库地址
 *  5.测试访问远程配置文件
 *config client:(写在eureka-provider)
 *  1.导入starter-config依赖
 *  2.配置config server地址，读取配置文件名称等信息
 *  3.获取配置值
 *  Config客户端刷新(使用config-server的http://localhost:8888/master/config-dev.yml会自动更新,但config的client不会更新)
 *  1.在config客户端引入actuator依赖
 *  2.获取配置信息类上，添加@RefreshScope注解
 *  3.添加配置(management.endpoints.web.exposure.include: refresh)
 * 4.使用curl工具发送post请求(curl -X POST http://localhost:8001/actuator/refresh)
 */
@EnableConfigServer //开启配置服务
@SpringBootApplication
@EnableEurekaClient //config-server整合eureka(使其他各模块动态获取config-server的ip)
public class ConfigServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp.class,args);
    }
}
