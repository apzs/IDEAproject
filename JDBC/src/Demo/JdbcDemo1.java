package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Data:2021/6/13
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //导入jar包
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
        //定义sql
        String sql = "select * from user";
        //获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString(3);
            System.out.println(id + "--" + username + "--" + password);
        }
        //处理结果
        //释放资源
        stmt.close();
        conn.close();



    }
}
