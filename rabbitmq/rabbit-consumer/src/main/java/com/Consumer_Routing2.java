package com;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 无名氏
 * @date 2022/1/14
 * @Description:  发布订阅模式消费者
 */
public class Consumer_Routing2 {
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
        String queue2 = "routing_queue2";
        channel.queueDeclare(queue2,false,false,false,null);
        //6、发送数据
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
                System.out.println("输出到控制台");
            }
        };
        channel.basicConsume(queue2,true,consumer);

        //不要关闭资源
    }
}
