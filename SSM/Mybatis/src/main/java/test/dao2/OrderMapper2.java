package test.dao2;

import org.apache.ibatis.annotations.*;
import test.domain.Orders;
import test.domain.User;
import test.domain.User_Orders;
import test.domain.UserMessage_Role;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public interface OrderMapper2 {

    @Select("select orders.id oid,orderTime,total,uid,username,password from test.orders join test.user on uid=user.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password")
    })
    List<Orders> findAllOrders();

//=======================================================================================================\\

    @Select("select id,orderTime,total,uid from test.orders")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",                //要封装的属性名称
                    column = "uid",                  //根据哪个字段去查user表的数据
                    javaType = User.class,    //要封装的实体类型
                    //select属性，代表查询那个接口的方法获得数据
                    one = @One(select = "test.dao2.UserMapper2.findUserById")
            )
    })
    List<Orders> findAllOrders2();

//=======================================================================================================\\

    @Select("select id,orderTime,total,uid from test.orders  where uid=#{uid}")
    List<Orders> findOrdersByUser(int uid);

    @Select("select id,username,password from test.user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "ordersList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "test.dao2.OrderMapper2.findOrdersByUser")
            )
    })
    List<User_Orders> findOrdersByUsers();

    List<UserMessage_Role> findAllOrderAndRole();
}
