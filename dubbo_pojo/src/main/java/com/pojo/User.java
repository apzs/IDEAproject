package com.pojo;

import java.io.Serializable;

/**
 * @author 无名氏
 * @date 2021/10/1
 * @Description: 所有的pojo都需要实现Serializable接口，以实现序列化(使service和web可以传输user对象数据)
 */
public class User implements Serializable {

    public int id;
    public String username;
    public String password;

    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
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
}
