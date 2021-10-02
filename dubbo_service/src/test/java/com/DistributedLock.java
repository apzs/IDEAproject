package com;

/**
 * @author 无名氏
 * @date 2021/10/2
 * @Description: TODO
 */
public class DistributedLock {

    public static void main(String[] args) {

        Ticket12306 ticket12306 = new Ticket12306();

        Thread t1 = new Thread(ticket12306,"携程");
        Thread t2 = new Thread(ticket12306,"飞猪");

        t1.start();
        t2.start();
    }

}
