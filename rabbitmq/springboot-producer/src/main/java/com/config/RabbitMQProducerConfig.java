package com.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 无名氏
 * @date 2022/1/16
 * @Description: TODO
 */
@Configuration
public class RabbitMQProducerConfig {

    public static final String EXCHANGE_NAME = "springboot_topic_exchange";
    public static final String QUEUE_NAME = "spring_boot_topic_queue";

    //1、交换机
    @Bean("topicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(false).autoDelete().build();
    }
    //2、Queue队列
    @Bean("topicQueue")
    public Queue topicQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }
    //3、队列和交换机的绑定关系Binding
    @Bean
    public Binding bindingQueueExchange(@Qualifier("topicExchange") Exchange exchange,@Qualifier("topicQueue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("#.error").noargs();
    }
}
