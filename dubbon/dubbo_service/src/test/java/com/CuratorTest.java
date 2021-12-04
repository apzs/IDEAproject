package com;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/10/1
 * @Description: TODO
 */
public class CuratorTest {

    private CuratorFramework client;

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

        client = CuratorFrameworkFactory.newClient("192.168.29.128:2181",
                60 * 1000, 15 * 1000, retryPolicy);
        //开启连接
        client.start();
    }

    @Before
    public void test2(){
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);
        //命名空间不需要存在(会自己创建)
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.29.128:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .namespace("user")
                .retryPolicy(retryPolicy).build();

        client.start();
    }

    @After
    public void close(){
        if (client!=null) {
            client.close();
        }
    }

    @Test
    public void creat() throws Exception {
//      1、基本创建 create /user/app1 (设置了lisa为命名空间)
//      如果创建节点，没有指定数据，则默认将当前客户端的ip作为数据存储
//      String path = client.create().forPath("/app1");
//      2、创建带有数据的节点 create /user/app1 hello
//      String path = client.create().forPath("/app1","hello".getBytes());
//      3.设置节点类型为临时节点(默认持久化) create -e /user/app1  (-e临时节点:当前会话有效 、-s有序节点:给该节点编号、-es)
//      String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app1","hello".getBytes());
//      4、创建多级节点
//      creatingParentsIfNeeded:如果父节点不存在则创建父节点(父节点不会设置ip作为数据)
        String path = client.create().creatingParentsIfNeeded().forPath("/app1/p1");
        System.out.println(path);
    }

    @Test
    public void get() throws Exception {
        //1.查询数据 get /user/app1/p1
        byte[] data = client.getData().forPath("/app1/p1");
        System.out.println(new String(data));
        //2.查询子节点 ls /user/app1
        List<String> list = client.getChildren().forPath("/app1");
        System.out.println(list);
        //3.查询节点的状态信息 ls -s /user/app1
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        System.out.println(stat);
    }

    @Test
    public void set() throws Exception {
        //修改数据  set /user/app1 hi
        client.setData().forPath("/app1","hi".getBytes());
        //根据版本修改
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        int version = stat.getVersion();
        System.out.println(version);
        client.setData().withVersion(version).forPath("/app1","hello".getBytes());
    }


    @Test
    public void delete() throws Exception {
        //1、删除节点
        client.delete().forPath("/app2");
        //2、删除带有子节点的节点
        client.delete().deletingChildrenIfNeeded().forPath("/app1");
        //3、必须删除成功(会话结束后还会请求删除)
        client.delete().guaranteed().forPath("/app1");
        //4、回调
        BackgroundCallback callback = new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("我被删除了");
                System.out.println(event);
            }
        };
        client.delete().guaranteed().inBackground(callback).forPath("/app1");

    }
}
