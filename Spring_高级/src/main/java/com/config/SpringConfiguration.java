package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 无名氏
 * @date 2021/9/23
 * spring的配置类，相当于applicationContext.xml的作用
 */
@Configuration
@Import(JdbcConfig.class)
public class SpringConfiguration {

}
