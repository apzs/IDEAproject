package com.hjnu.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.hjnu.mybatis.enums.SexEnum;

/**
 * @author 无名氏
 * @date 2022/3/2
 * @Description: TODO
 */

/**
 *@TableName("t_user")  与数据库表名t_user相对应
 * SELECT uid AS id,nickname AS name,age,email FROM t_user WHERE uid=?
 */
@TableName("t_user")
public class User {
    /**
     * @TableId 主键可以使用
     * value = "uid" 与数据库字段uid相对应
     * type为主键生成策略 默认IdType.NONE(雪花算法)
     * type = IdType.AUTO 设置主键为自动增长
    */
    @TableId(value = "uid",type = IdType.AUTO)
    public Long id;

    /**
     * @TableField("nickname") :非主键使用
     * 与数据库字段nickname相对应
     */
    @TableField("nickname")
    public String name;

    public Integer age;

    public SexEnum sex;

    public String email;

    /**
     * @TableLogic 如果加上该注解，则在执行删除操作时，会将该字段的值置为1，不删除数据
     *  UPDATE t_user SET is_deleted=1 WHERE uid=? AND is_deleted=0
     *  在执行查询操作时自动加上is_deleted=0
     *  SELECT uid AS id,nickname AS name,age,email,is_deleted FROM t_user WHERE uid IN ( ? , ? , ? , ? ) AND is_deleted=0
     */
    @TableLogic
    public Integer isDeleted;


    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
