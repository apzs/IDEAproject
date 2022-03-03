package com.rabbitmq.ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @author 无名氏
 * @date 2022/1/18
 * @Description: TODO
 */
public class DlxListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //1、接收转换消息
            System.out.println("DlxListener:"+new String(message.getBody()));
            //2、处理业务逻辑
            System.out.println("处理业务逻辑...");
            int i= 3/0;
            //3、手动签收
            /*
             * basicAck(long deliveryTag, boolean multiple)
             *  deliveryTag: 当前收到消息的标签
             *  multiple: 可以允许签收多条消息
             */
            channel.basicAck(deliveryTag,true);
        }catch (Exception e){
            //4、拒绝签收
            /*
             * basicNack(long deliveryTag, boolean multiple, boolean requeue)
             *  deliveryTag: 当前收到消息的标签
             *  multiple: 可以允许签收多条消息如果设置为true，则消息重新回到queue，broker会重新发送该消息给消费端
             *  requeue: 重回队列，
             */
            //===================设置不重回队列=============================================
            channel.basicNack(deliveryTag,true,false);
            //少了个multiple
            //channel.basicReject(deliveryTag,false);
        }
    }
}
