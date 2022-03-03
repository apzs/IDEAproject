package com.rabbitmq.ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @author 无名氏
 * @date 2022/1/18
 * @Description: xml中监听死信队列，而不是provider发消息发送到的队列
 */
public class DelayListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //1、接收转换消息
        System.out.println("DelayListener:"+new String(message.getBody()));
        //签收
        channel.basicAck(deliveryTag, true);
    }
}
