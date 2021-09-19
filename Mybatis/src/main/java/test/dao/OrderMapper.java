package test.dao;

import test.domain.Orders;
import test.domain.UserMessage2;
import test.domain.UserMessage3;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public interface OrderMapper {

    List<Orders> findAllOrders();

    List<UserMessage2> findOrdersByUsers();

    List<UserMessage3> findAllOrderAndRole();
}
