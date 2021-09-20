package test.domain;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/17
 */
public class User_Orders {

    private int id;
    private String username;
    private String password;

    //描述的是当前用户存在哪些订单
    private List<Orders> ordersList;
    public User_Orders() {
    }

    public User_Orders(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ordersList=" + ordersList +
                '}';
    }
}
