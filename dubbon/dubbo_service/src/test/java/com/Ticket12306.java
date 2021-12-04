package com;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * @author 无名氏
 * @date 2021/10/2
 * @Description: TODO
 */
public class Ticket12306 implements Runnable{

    //票数
    private int tickets = 10;
    //分布式锁
    private InterProcessMutex lock;

    public Ticket12306() {

        RetryPolicy  retryPolicy = new ExponentialBackoffRetry(3000,10);

        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.29.128:2181",
                60 * 1000, 15 * 1000, retryPolicy);
        client.start();
        //不需要节点存在(会自己创建)
        lock = new InterProcessMutex(client,"/login");
    }

    @Override
    public void run() {

        try {
            //acquire(时间,单位);
            lock.acquire(3, TimeUnit.SECONDS);
            while (tickets > 0){
                System.out.println(Thread.currentThread()+" : "+ tickets);
                tickets--;
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
