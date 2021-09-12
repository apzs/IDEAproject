package login.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("login")
@Import(DataSourceConfiguration.class)
//@Import({DataSourceConfiguration.class,xxx.class})
public class SpringConfiguration {
        //Spring核心配置文件
}
