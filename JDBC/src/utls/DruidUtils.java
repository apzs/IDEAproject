package utls;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Data:2021/6/13
 */
public class DruidUtils {
    private static DataSource ds = null;
    static {
        Properties pro = new Properties();
        try {
/*          System.out.println(DruidUtils.class.getClassLoader().getResource(""));
            System.out.println(DruidUtils.class.getClassLoader().getResource("/"));
            System.out.println();
            System.out.println(DruidUtils.class.getResource(""));
            System.out.println(DruidUtils.class.getResource("/"));
            System.out.println();
*/
            pro.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //归还资源
    public static void close(Connection conn, Statement stmt){
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close(conn,stmt);
    }
    //获取连接池对象
    public static DataSource getDateSource() {
        return ds;
    }

    //获取一个连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
