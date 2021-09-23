package com.config;

import com.condition.MyConditionOnClass;
import com.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
@Configuration
public class UserConfig {
    @Bean
    //@Conditional(ClassCondition.class)
    @MyConditionOnClass("redis.clients.jedis.Jedis")
    public User user(){
        return new User();
    }
}
