import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 无名氏
 * @date 2022/1/17
 * @Description: 消息的可靠性投递
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producers.xml")
public class Confirm {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*
        确认模式(发送给Exchange失败)
        步骤
            1、确认模式开启，connectionFactory中开启 publisher-confirms="true"
            2、在rabbitTemplate定义ConfirmCallback回调函数(不论成功失败都会执行)
     */

    @Test
    public void confirmTest() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             *
             * @param correlationData 相关配置信息
             * @param ack  exchange交换机是否成功接收到了消息。
             * @param cause 失败原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("confirm 执行了......");
                if (ack) {
                    //cause为null
                    System.out.println("执行成功 " + cause);
                } else {
                    System.out.println("执行失败 " + cause);
                }
            }
        });

        rabbitTemplate.convertAndSend("confirm_exchange", "order.error", "执行消息11...");
        rabbitTemplate.convertAndSend("confirm_exchange111", "order.error", "执行消息12...");
    }

    /*
        回退模式: 当消息发送给Exchange后，Exchange路由到Queue，失败时才会执行 ReturnCallBack
        步骤:
           1、回退模式开启，connectionFactory中开启 publisher-confirms="true"
           2、设置ReturnCallBack(不论成功失败都会执行)
           3、设置Exchange处理消息的模式:
               1、如果消息没有路由到Queue，则丢弃消息(默认)
               2、如果消息没有路由到Queue，返回给消息发送方ReturnCallBack
     */
    @Test
    public void returnTest() {
        //设置Exchange处理失败消息的模式
        rabbitTemplate.setMandatory(true);
        //设置ReturnCallBack
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             *
             * @param message   消息信息
             * @param replyCode 错误码
             * @param replyText 错误信息
             * @param exchange  交换机
             * @param routingKey 路由键
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("return 执行了...");

                System.out.println(message);
                System.out.println(replyCode);
                System.out.println(replyText);
                System.out.println(exchange);
                System.out.println(routingKey);
            }
        });
        rabbitTemplate.convertAndSend("confirm_exchange", "order.error", "执行消息21...");
        rabbitTemplate.convertAndSend("confirm_exchange", "order.error111", "执行消息22...");
    }

    @Test
    public void qosTest() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("confirm_exchange", "order.info", "执行消息31..." + i);
        }
    }

    /**
     *ttl 如果同时设置了消息的过期时间,同时也设置了队列的过期时间,则以时间短的为准
     * 队列过期后,会将队列所有消息全部移除
     * 消息过期后,只有消息在队列顶端,才会判断其是否过期(移除掉)
     */

    /**
     * 队列统一过期
     * xml文件配置
     * <entry key="x-message-ttl" value="10000" value-type="java.lang.Integer"/>
     */
    @Test
    public void ttlTest1() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("ttl_exchange", "order.ttl", "执行消息 ttl..." + i);
        }
    }

    /**
     * 消息单独过期(如果同时设置了消息的过期时间,同时也设置了队列的过期时间,则以时间短的为准)
     */
    @Test
    public void ttlTest2() {
        //消息后处理对象,设置一些消息的参数信息
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //消息过期时间
                message.getMessageProperties().setExpiration("5000");
                //返回该消息
                return message;
            }
        };

        rabbitTemplate.convertAndSend("ttl_exchange", "order.ttl", "执行消息 ttl2...", messagePostProcessor);
    }

    /**
     * DLX 死信队列
     * 消息成为死信的三种情况
     *   1、队列消息长度达到限制
     *   2、消费者拒接消费消息，并且不重回队列
     *   3、原队列存在消息过期设置，消息达到超时时间未被消费
     */
    @Test
    public void dlxTest(){
        //测试x-message-ttl队列的过期时间
        rabbitTemplate.convertAndSend("dlx_exchange","order.info","发送了一个通知...");
        for (int i = 10; i > 0; i--) {
            try {
                //15秒钟之后consumer才能看到消息
                Thread.sleep(1000);
                System.out.println(i +"...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //测试x-max-length-bytes队列长度限制
        for (int i = 0; i < 21; i++) {
            rabbitTemplate.convertAndSend("dlx_exchange","order.info","发送的第"+i+"个通知");
        }
        //消费者拒接消费消息，并且不重回队列
        //DlxListener中设置channel.basicNack(deliveryTag,true,false);
        rabbitTemplate.convertAndSend("dlx_exchange","order.warning","发送了一个警告");
    }

    @Test
    public void delayTest(){
        //测试延迟队列
        rabbitTemplate.convertAndSend("delay_exchange","delay","发送了一个延迟消息...");
        for (int i = 15; i > 0; i--) {
            try {
                //15秒钟之后consumer才能看到消息
                Thread.sleep(1000);
                System.out.println(i +"...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
