package com.rabbitmq.ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @author 无名氏
 * @date 2022/1/17
 * @Description:
 * Consumer ACK机制
 * 1、设置手动签收。listener-container中设置acknowledge="manual"
 * 2、让监听器类实现ChannelAwareMessageListener接口
 * 3、如果消息处理，则调用channel的basicAck()签收
 * 4、如果消息处理失败,则调用channel的basicNAck()拒绝签收，broker重新发送给consumer
 */
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //1、接收转换消息
            System.out.println(new String(message.getBody()));
            //2、处理业务逻辑
            System.out.println("处理业务逻辑...");
            //3、手动签收
            /**
             * basicAck(long deliveryTag, boolean multiple)
             *  deliveryTag: 当前收到消息的标签
             *  multiple: 可以允许签收多条消息
             */
            channel.basicAck(deliveryTag,true);
        }catch (Exception e){
            //4、拒绝签收
            /**
             * basicNack(long deliveryTag, boolean multiple, boolean requeue)
             *  deliveryTag: 当前收到消息的标签
             *  multiple: 可以允许签收多条消息如果设置为true，则消息重新回到queue，broker会重新发送该消息给消费端
             *  requeue: 重回队列，
             */
            channel.basicNack(deliveryTag,true,true);
            //少了个multiple
            //channel.basicReject(deliveryTag,true);
        }
    }
}
