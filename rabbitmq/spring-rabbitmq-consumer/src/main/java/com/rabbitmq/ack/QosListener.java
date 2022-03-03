package com.rabbitmq.ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @author 无名氏
 * @date 2022/1/17
 * @Description:
 * Consumer 限流机制
 * 1、确保ack机制为手动确认(acknowledge="manual")
 * 2、listener-container配置属性
 *     prefetch="2"表示消费端每次从mq拉取2条消息来消费，知道手动确认消费完毕后，才会继续拉取下一条消息
 */
public class QosListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        //1、接收转换消息
        System.out.println(new String(message.getBody()));
        //2、处理业务逻辑

        //3、手动签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
