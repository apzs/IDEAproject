package com;

import login.config.MyImportBeanDefinitionRegistrar;
import login.domain.DomainTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author 无名氏
 * @date 2021/9/20
 * @ComponentScan 扫描范围:当前引导类所在包及其子包
 * 1、@ComponentScan("login.domain") 扫描Spring_anno模块的login.domain包
 * 2、@Import(SpringConfiguration.class)导入Spring_anno模块的配置类
 * 3、@EnableUser 使用Spring_anno模块定义的@EnableUser
 */

/**
 * Import的四种用法
 * 1、@Import(DomainTest.class)
 * 2、@Import(SpringConfiguration.class)
 * 3、@Import(MyImportSelector.class)需要实现ImportSelector方法返回bean名称数组
 * 4、@Import(MyImportBeanDefinitionRegistrar.class)
 */
@Import(MyImportBeanDefinitionRegistrar.class)
@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HelloApplication.class, args);
        Object user = applicationContext.getBean(DomainTest.class);
        System.out.println(user);
    }
}
