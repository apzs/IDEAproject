package Demo;

import utls.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @
 * @Data:2021/6/13
 */
public class JdbcDemo3 {

    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(String[] args) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "insert into user values (null,'acvww','sdfff')";
            stmt =conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,stmt);
        }

    }
}
