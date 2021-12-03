package com.consumer.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

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

    @Bean
    Request.Options requestOptions(ConfigurableEnvironment env){
        int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 3000);
        int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 6000);
        return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
    }

}
