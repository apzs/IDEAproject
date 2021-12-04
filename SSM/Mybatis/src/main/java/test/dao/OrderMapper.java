package test.dao;

import test.domain.Orders;
import test.domain.UserMessage_Orders;
import test.domain.UserMessage_Role;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public interface OrderMapper {

    List<Orders> findAllOrders();

    List<UserMessage_Orders> findOrdersByUsers();

    List<UserMessage_Role> findAllOrderAndRole();
}
