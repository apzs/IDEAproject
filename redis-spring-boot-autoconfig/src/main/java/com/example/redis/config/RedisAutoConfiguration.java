package com.example.redis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author 无名氏
 * @date 2021/9/23
 */
@Configuration
public class RedisAutoConfiguration {

    /**
     * 提供jedis的Bean
     * @return
     */
    @Bean
    public Jedis jedis(){
        return new Jedis("localhost",6379);
    }
}
