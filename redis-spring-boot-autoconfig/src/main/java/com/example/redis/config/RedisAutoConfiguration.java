package com.example.redis.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author 无名氏
 * @date 2021/9/23
 */
@EnableConfigurationProperties(RedisProperties.class)
@Configuration
//Jedis.class存在时才加载这个Bean
@ConditionalOnClass(Jedis.class)
public class RedisAutoConfiguration {

    /**
     * 提供jedis的Bean
     * @return
     */
    @Bean("jedis")
    //如果用户自定义了jedis的Bean就不加载
    @ConditionalOnMissingBean(name = "jedis")
    public Jedis jedis(RedisProperties redisProperties){
        return new Jedis(redisProperties.getHost(),redisProperties.getPort());
    }
}
