package com.example.spring_boot_server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author 无名氏
 */
@EnableAdminServer
@SpringBootApplication
//继承SpringBootServletInitializer类重写configure方法并在pom文件配置<packaging>war</packaging>
//在build中<finalName>springboot</finalName>可以设置打包的名字
public class SpringBootServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootServerApplication.class);
	}
}
