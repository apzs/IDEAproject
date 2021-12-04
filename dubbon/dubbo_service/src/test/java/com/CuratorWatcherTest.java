package com;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 无名氏
 * @date 2021/10/2
 * @Description: Watch事件监听
 */
public class CuratorWatcherTest {
    private CuratorFramework client;

    @Before
    public void begin() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);

        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.29.128:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .namespace("user")
                .retryPolicy(retryPolicy)
                .build();

        client.start();
    }

    @After
    public void end() {
        if (client != null) {
            client.close();
        }
    }

    /**
     * NodeCatch:给指定一个节点注册监听器
     * 需要在客户端执行增删查才可以看到
     * 例: create /user/app1
     * 例: set /user/app1 hi
     * 例: delete /user/app1
     */
    @Test
    public void NodeCache() throws Exception {
        //1、创建NodeCache对象
        final NodeCache nodeCache = new NodeCache(client, "/app1");
        //2、注册监听(增删改方法会调用 例:set /user/app1 hi，查不会调用)
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了");
                //获取修改后的数据
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });
        //3、开启监听 (如果设置为true,则开启监听是加载缓冲数据)
        nodeCache.start();

        while (true) {

        }
    }

    /**
     * PathChildrenCache:监听某个节点的所有子节点
     * @throws Exception
     */
    @Test
    public void PathChildrenCache() throws Exception {
        //1、创建PathChildrenCache对象
        final PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app1", true);
        //2、注册监听(增删改方法会调用 例:set /user/app1 hi，查不会调用)
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
             @Override
             public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                 System.out.println("子节点变化了...");
                 System.out.println(event);
                 //监听子节点的数据变更
                 //1、获取类型
                 PathChildrenCacheEvent.Type type = event.getType();
                 //2、判断类型是否为update(set /user/app1/p1 hello)
                 if (PathChildrenCacheEvent.Type.CHILD_UPDATED.equals(type)) {
                     System.out.println("更新数据");
                     //PathChildrenCacheEvent{type=CHILD_UPDATED,
// data=ChildData{path='/app1/p1', stat=196,214,1633164223429,1633166992238,3,0,0,0,5,0,196,data=[104, 101, 108, 108, 111]}}
                     //访问data中的data
                     byte[] data = event.getData().getData();
                     System.out.println(new String(data));
                 }
             }
        });
        //3、开启监听 (如果设置为true,则开启监听是加载缓冲数据)
        pathChildrenCache.start();

        while (true) {

        }
    }

    /**
     * TreeCache:监听某个节点和该节点的所有子节点
     * @throws Exception
     */
    @Test
    public void TreeCache() throws Exception {
        TreeCache treeCache = new TreeCache(client,"/app1");
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("节点变化了");
                System.out.println(treeCacheEvent);
            }
        });

        treeCache.start();
        while (true){

        }
    }


}
