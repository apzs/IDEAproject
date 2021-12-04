package com.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 无名氏
 * @date 2021/11/28
 * @Description: TODO
 */
@Configuration
public class MyRule {

    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
