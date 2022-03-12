package com.hjnu.mybatis.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 无名氏
 * @date 2022/3/10
 * @Description: TODO
 */
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchConfig {

    private String host;
    private int port;

    @Bean
    public RestHighLevelClient client(){
        HttpHost httpHost = new HttpHost(host, port, "http");
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(httpHost));
        return client;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
