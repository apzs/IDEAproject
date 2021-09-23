package com.example.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 无名氏
 * @date 2021/9/23
 */
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String host = "localhost";
    private int port = 6379;

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
