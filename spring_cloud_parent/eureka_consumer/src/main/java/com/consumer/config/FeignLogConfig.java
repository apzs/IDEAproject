package com.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 无名氏
 * @date 2021/11/29
 * @Description: TODO
 */
@Configuration
public class FeignLogConfig {
/**
    NONE ,不记录
    BASIC,记录基本的请求行，响应状态码数据
    HEADERS,记录基本的请求行，响应状态码数据，记录响应头信息
    FULL ;记录完成的请求响应数据
*/
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
