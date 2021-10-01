package com.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

/**
 * @author 无名氏
 * @date 2021/10/1
 * @Description: TODO
 */
public class CuratorTest {

    /**
     * 建立连接
     */
    @Test
    public void testCurator(){
        /*
         * @param connectString       连接字符串。 zk server 地址和端口 如"192.168.29.128:2181,192.168.29.129:2181"
         * @param sessionTimeoutMs    会话超时时间 单位ms
         * @param connectionTimeoutMs 连接 超时时间 单位ms
         * @param retryPolicy         重试策略
         * @return client
         */
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);

        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.29.128:2181",
                60 * 1000, 15 * 1000, retryPolicy);
        //开启连接
        client.start();
    }

    @Test
    public void test2(){
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);

        CuratorFramework clint = CuratorFrameworkFactory.builder()
                .connectString("192.168.29.128:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy).build();

        clint.start();

    }
}














