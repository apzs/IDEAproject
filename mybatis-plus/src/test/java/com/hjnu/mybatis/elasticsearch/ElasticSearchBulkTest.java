package com.hjnu.mybatis.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 无名氏
 * @date 2022/3/11
 * @Description: 批量操作
 */
@SpringBootTest
public class ElasticSearchBulkTest {

    @Autowired
    private RestHighLevelClient client;

    /**
         POST _bulk
         {"delete":{"_index" : "index_test","_id" : "2"}}
         {"create":{"_index" : "index_test","_id" : "8"}}
         {"name":"八号","age":20,"address":"北京"}
         {"update":{"_index":"index_test","_id" : "2"}}
         {"doc":{"name":"二号"}}
     */
    @Test
    public void test(){

    }
}
