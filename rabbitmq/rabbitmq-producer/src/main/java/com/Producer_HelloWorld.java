package com;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 无名氏
 * @date 2022/1/14
 * @Description: 简单模式生产者
 */
public class Producer_HelloWorld {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2、修改配置信息
        factory.setHost("192.168.19.128");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        //3、创建Connection
        Connection connection = factory.newConnection();
        //4、创建Channel
        Channel channel = connection.createChannel();
        //5、创建队列Queue(如果没有则创建，如果有则不创建)
        /*
        queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
           1、queue:队列名称
           2、durable:是否持久化
           3、exclusive
               *是否独占,只能有一个消费者监听这个队列
               *当Connection关闭时,是否删除队列
           4、autoDelete:当没有Consumer时,是否自动删除
           5、arguments:参数信息
         */
        channel.queueDeclare("hello_world",false,false,false,null);
        //6、发送数据
        /*
        basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
        1、exchange:交换机名，简单模式下会使用默认的交换机 ""
        2、routingKey:路由名称(简单模式下路由名称需要与queue名称一致)
        3、props:配置信息
        4、body:发送消息数据
         */
        channel.basicPublish("","hello_world",null,"hello rabbitmq".getBytes());
        //释放资源
        channel.close();
        connection.close();
    }
}
