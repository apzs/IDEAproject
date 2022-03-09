package com.hjnu.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.Version;

/**
 * @author 无名氏
 * @date 2022/3/7
 * @Description: 乐观锁测试实体类
 */

public class Product {
    private Long id;
    private String name;
    private Integer price;

    /**
     * 标识乐观锁对应的版本号
     */
    @Version
    private Integer version;

    public Product() {
    }

    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", version=" + version +
                '}';
    }
}

