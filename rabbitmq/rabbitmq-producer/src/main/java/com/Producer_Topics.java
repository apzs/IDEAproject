package com;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 无名氏
 * @date 2022/1/14
 * @Description: 定向类型交换机
 */
public class Producer_Topics {
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
        //5.创建交换机
        /*
        exchangeDeclareNoWait(String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments)
        1、exchange: 交换机名称
        2、type：交换机类型(枚举)
            DIRECT("direct"), 定向
            FANOUT("fanout"), 扇形(广播),发送消息到每个与之绑定的队列
            TOPIC("topic"), 通配符方式
            HEADERS("headers"); 参数匹配
        3、durable：是否持久化
        4、autoDelete：是否自动删除
        5、internal：内部使用，一般为false
        6、arguments：参数
         */
        String exchangeName = "topic";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, false, false, false, null);
        //6、创建队列Queue(如果没有则创建，如果有则不创建)
        String queue1 = "topic_queue1";
        String queue2 = "topic_queue2";
        channel.queueDeclare(queue1, false, false, false, null);
        channel.queueDeclare(queue2, false, false, false, null);
        //7、绑定队列与交换机
        /*
            * 表示一个单词
            # 表示0~多个单词
         */
        channel.queueBind(queue1, exchangeName, "*.error");

        channel.queueBind(queue2, exchangeName, "#.info");
        channel.queueBind(queue2, exchangeName, "#.error");
        channel.queueBind(queue2, exchangeName, "warning");
        //8、发送数据
        //basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
        channel.basicPublish(exchangeName, "order.info", null, "info 提示信息".getBytes());
        channel.basicPublish(exchangeName, "order.error", null, "error order操作失败".getBytes());
        channel.basicPublish(exchangeName, "error", null, "error 操作失败1".getBytes());
        channel.basicPublish(exchangeName, "user.order.error", null, "error 操作失败2".getBytes());
        //释放资源
        channel.close();
        connection.close();
    }
}
