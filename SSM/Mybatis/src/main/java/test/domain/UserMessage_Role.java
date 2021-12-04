package test.domain;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public class UserMessage_Role {
    private int id;
    private String name;
    private String birthday;

    //描述的是当前用户存在哪些方法
    private List<Orders> ordersList;

    //描述的是当前用户存在那些订单
    private List<Role> roleList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserMessage3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
