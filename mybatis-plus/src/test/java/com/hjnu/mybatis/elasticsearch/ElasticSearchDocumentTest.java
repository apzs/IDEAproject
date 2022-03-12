package com.hjnu.mybatis.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.hjnu.mybatis.pojo.ESUser;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 无名氏
 * @date 2022/3/11
 * @Description: 操作文档(重要)
 */
@SpringBootTest
public class ElasticSearchDocumentTest {

    @Autowired
    public RestHighLevelClient client;

    /**
     * 通过map添加或修改文档(如果id不存在则添加，如果id存在则修改)
     * @throws IOException
     */
    @Test
    public void insertOrUpdateDocByMap() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("name","张三");
        data.put("age",21);
        data.put("message","华为5G手机");
        IndexRequest indexRequest = new IndexRequest("index_test").id("1").source(data, XContentType.JSON);
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.getId());
    }

    /**
     * 通过 json字符串 添加或修改文档(如果id不存在则添加，如果id存在则修改)
     * 使用fastjson工具将对象转换成json字符串
     * @throws IOException
     */
    @Test
    public void insertOrUpdateDocByObject() throws IOException {
        ESUser user = new ESUser("李四",22,"三星5G手机");
        //使用fastjson将对象转换成json
        String data = JSON.toJSONString(user);
        System.out.println(data);
        IndexRequest indexRequest = new IndexRequest("index_test").id("2").source(data, XContentType.JSON);
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.getId());
    }

    /**
     * 查询文档
     * @throws IOException
     */
    @Test
    public void queryDoc() throws IOException {
        GetRequest getRequest = new GetRequest("index_test","1");
        //GetRequest getRequest = new GetRequest("index_test");
        //getRequest.id();
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
    }

    @Test
    public void deleteDoc() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("index_test","1");
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response.getId());
    }
}
