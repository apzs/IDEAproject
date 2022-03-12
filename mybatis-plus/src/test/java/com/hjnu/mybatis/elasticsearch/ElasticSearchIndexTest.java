package com.hjnu.mybatis.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

/**
 * @author 无名氏
 * @date 2022/3/10
 * @Description: 操作索引(不太重要)
 */
@SpringBootTest
public class ElasticSearchIndexTest {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void test(){
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(
                new HttpHost("127.0.0.1",9200,"http")
        ));

        System.out.println(client);
    }


    /**
     *添加索引
     */
    @Test
    public void addIndex() throws IOException {
        //使用client获取操作索引对象
        IndicesClient indices = client.indices();
        //创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index_test");
        CreateIndexResponse response = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        //获取返回结果
        System.out.println(response.isAcknowledged());
    }

    /**
     * 添加索引和映射
     */
    @Test
    public void addIndexAndMapping() throws IOException {
        //使用client获取操作索引对象
        IndicesClient indices = client.indices();
        //创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index_and_mapping_test");
        createIndexRequest.mapping(" {\n" +
                "      \"properties\" : {\n" +
                "        \"age\" : {\n" +
                "          \"type\" : \"integer\"\n" +
                "        },\n" +
                "        \"message\" : {\n" +
                "          \"type\" : \"text\",\n" +
                "          \"analyzer\" : \"ik_max_word\"\n" +
                "        },\n" +
                "        \"name\" : {\n" +
                "          \"type\" : \"keyword\"\n" +
                "        }\n" +
                "      }\n" +
                "    }", XContentType.JSON);
        CreateIndexResponse response = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        //获取返回结果
        System.out.println(response.isAcknowledged());
    }

    /**
     * 查询索引(如果索引不存在则报错)
     * @throws IOException
     */
    @Test
    public void queryIndex() throws IOException {
        IndicesClient indices = client.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest("index_and_mapping_test");
        GetIndexResponse response = indices.get(getIndexRequest, RequestOptions.DEFAULT);
        Map<String, MappingMetaData> mappings = response.getMappings();
        mappings.forEach((k,v)->System.out.println(k+" === "+v.getSourceAsMap()));
    }

    /**
     * 查询索引是否存在
     * @throws IOException
     */
    @Test
    public void exitsIndex() throws IOException {
        IndicesClient indices = client.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest("index_and_mapping_test");
        boolean exists = indices.exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    public void deleteIndex() throws IOException {
        IndicesClient indices = client.indices();
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("index_and_mapping_test");
        AcknowledgedResponse response = indices.delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }




}
