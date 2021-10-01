package com.controller;

import com.pojo.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

/**
 * @author 无名氏
 * @date 2021/9/30
 * 服务的消费者
 * 启动顺序 安装dubbo_pojo  -> 安装dubbo_interface  ->  启动dubbo_service  ->  启动dubbo_web
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * @Reference 从zookeeper注册中心获取userService的访问url(第一次访问注册中心后回记录访问路径，在访问不会去组策中心（若路径更改注册中心会通知服务消费方）)
     * timeout、  服务的消费方和服务的提供方同时配置timeout则消费方配置有效(一般timeout配置在提供方,因为服务的提供方能预计数据库查询的时间)
     * version、  访问提供方2.0版本
     * loadbalance负载均衡策略有4种可选
                   1、random(按权重随机)按权重根据概率随机访问(默认)
                   2、roundrobin(按权重轮询)比方说3个机器的权重分别为 100 200 100 则访问机器的顺序必为 1->2->3->2
                   3、leastactive(最小活跃调用数，相同活跃数的随机)服务消费方每次都询问服务提供方各自最后一次处理的请求花费了多少毫秒
                   4、ConsistentHash:(一致性 Hash,相同参数的请求总是发到同一提供者。)
     * cluster、  集群容错模式
                   1、failover 失败重试,默认失败两次(默认)一般用于读操作
                   2、failfast 快速失败、只发起一次调用，失败立即报错，一般用于写操作
                   3.failsafe  失败安全，出现异常时,直接忽略。返回一个空结果。 一般用于写日志不太重要的操作
                   4、failback  失败自动恢复，后台记录失败请求,定时重发。 一般用于非常重要的操作
                   5、forking   并行调用多个服务器，只要一个成功即返回。 比较耗性能
                   Broadcast Cluster :广播调用所有提供者,逐个调用，任意一台报错则报错。一般用于服务消费方要更新服务提供方数据，服务提供方数据要保持同步

     * mock、     服务降级方式: .
                 mock=force:return null表示消费方对该服务的方法调用都直接返回null值，不发起远程调用。用来屏蔽不重要服务不可用时对调用方的影响。
                 mock=fail:return null表示消费方对该服务的方法调用在失败后，再返回null值，不抛异常。用来容忍不重要服务不稳定时对调用方的影响。
     */

    @Reference(timeout = 1000,version = "v2.0",loadbalance = "random",cluster = "failover",mock = "fail:return null")//远程访问服务的提供方
    public UserService userService;

    //http://localhost:8000/user/sayHello.do
    @RequestMapping("/sayHello")
    public String sayHello() {
        return  userService.sayHello();
    }


    //http://localhost:8000/user/find.do?id=1
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/find")
    public User find(int id) {
        return  userService.findUserById(id);
    }

}
