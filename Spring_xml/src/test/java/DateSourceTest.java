import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * @author 无名氏
 * @Data 2021/7/17
 */
public class DateSourceTest {
    //不用写成druid。properties
    ResourceBundle rb = ResourceBundle.getBundle("jdbc");
    String driver = rb.getString("driver");
    String url = rb.getString("url");
    String username = rb.getString("username");
    String password = rb.getString("password");

    @Test
    public void test1() throws PropertyVetoException, SQLException {

        ComboPooledDataSource cb = new ComboPooledDataSource();
        cb.setDriverClass(driver);
        cb.setJdbcUrl(url);
        cb.setUser(username);
        cb.setPassword(password);

        Connection connection = cb.getConnection();
        System.out.println(connection);
        String sql = "select * from user where username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"zhangsan");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            System.out.println(id +"=="+ username);
        }
        connection.close();
    }

    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource cb = (ComboPooledDataSource) app.getBean("dataSource");
        System.out.println(cb);
      JdbcTemplate template = new JdbcTemplate(cb);
        String sql = "insert into user(id, username, password) values (null,?,?)";
        int i = template.update(sql, "2yyfuuyf2", "edfgg");
        System.out.println(i);
    }
}
