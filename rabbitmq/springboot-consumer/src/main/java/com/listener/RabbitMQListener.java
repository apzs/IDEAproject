package com.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 无名氏
 * @date 2022/1/16
 * @Description: TODO
 */
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "spring_boot_topic_queue")
    public void listenerQueue(Message message){
        System.out.println(new String(message.getBody()));
    }
}
