package Demo;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 无名氏
 * @Data:2021/6/13
 */
public class JdbcDemo5_Druid {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties pro = new Properties();
        InputStream inputStream = JdbcDemo5_Druid.class.getClassLoader()
                            .getResourceAsStream("druid.properties");
        pro.load(inputStream);
        //4.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //5.获取连接
        Connection conn = ds.getConnection();

    }
}
