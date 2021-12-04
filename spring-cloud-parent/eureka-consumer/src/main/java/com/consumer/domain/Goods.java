package com.consumer.domain;

/**
 * @author 无名氏
 * @date 2021/10/3
 * @Description: TODO
 */
public class Goods {
    private int id;
    private String title;
    private double price;
    private int count;

    public Goods() {
    }

    public Goods(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
