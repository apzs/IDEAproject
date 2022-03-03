import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 无名氏
 * @date 2022/1/16
 * @Description: TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producers.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void helloWorld(){
        //direct消息
        rabbitTemplate.convertAndSend("spring_queue","Hello World...");
    }

    @Test
    public void Fanout(){
        //fanout(广播)消息
        rabbitTemplate.convertAndSend("spring_fanout_exchange","","fanout...");
    }

    @Test
    public void Routing(){
        //routing(路由)消息
        rabbitTemplate.convertAndSend("spring_routing_exchange","order.info","routing order.info...");
        rabbitTemplate.convertAndSend("spring_routing_exchange","order.error","routing order.error...");
    }

    @Test
    public void Topic(){
        //topic(通配符)消息
        rabbitTemplate.convertAndSend("spring_topic_exchange","order.error","topic order.error...");
        rabbitTemplate.convertAndSend("spring_topic_exchange","order.warning","topic order.warning...");
        rabbitTemplate.convertAndSend("spring_topic_exchange","user.order.warning","topic user.order.warning...");
    }
}
