package com;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 无名氏
 * @date 2022/1/14
 * @Description:  发布订阅模式消费者
 */
public class Consumer_Topic1 {
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
        String queue1 = "topic_queue1";
        channel.queueDeclare(queue1,false,false,false,null);
        //6、发送数据
        /*
        basicConsume(String queue, boolean autoAck, Consumer callback)
        1、queue:队列名称
        2、autoAck:是否自动确认
        3、callback:回调对象
         */
        Consumer consumer = new DefaultConsumer(channel){
            //回调方法(当收到消息后，会自动执行该方法)
            /*
            1、consumerTag:标识
            2、envelope:获取一些信息,如交换机、路由key...
            3、properties:配置信息
            4、body:数据
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
                System.out.println("保存信息");
            }
        };
        channel.basicConsume(queue1,true,consumer);

        //不要关闭资源
    }
}
