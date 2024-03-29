package test.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.dao.OrderMapper;
import test.domain.Orders;
import test.domain.UserMessage;
import test.domain.UserMessage_Orders;
import test.domain.UserMessage_Role;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public class UserOrderDemo {
    public static void main(String[] args) throws IOException {
        UserMessage userMessage = new UserMessage();
        userMessage.setName("lisa");
        userMessage.setBirthday(new Date());

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> allOrders = mapper.findAllOrders();
        for (Orders allOrder : allOrders) {
            System.out.println(allOrder);
        }

        System.out.println("====================================================");
        List<UserMessage_Orders> list = mapper.findOrdersByUsers();
        for (UserMessage_Orders userMessage2 : list) {
            System.out.println(userMessage2);
        }


        System.out.println("====================================================");
        List<UserMessage_Role> allOrderAndRole = mapper.findAllOrderAndRole();
        for (UserMessage_Role userMessage3 : allOrderAndRole) {
            System.out.println(userMessage3);
        }

    }
}
