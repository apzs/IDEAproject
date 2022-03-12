package com.hjnu.mybatis.pojo;

/**
 * @author 无名氏
 * @date 2022/3/11
 * @Description: elasticsearch测试实体
 */
public class ESUser {

    private String name;
    private Integer age;
    private String message;

    public ESUser() {
    }

    public ESUser(String name, Integer age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ESUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", message='" + message + '\'' +
                '}';
    }
}
