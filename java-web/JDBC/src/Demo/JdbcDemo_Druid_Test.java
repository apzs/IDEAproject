package Demo;

import utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Data:2021/6/13
 */
public class JdbcDemo_Druid_Test {

    private static Connection conn = null;
    private static PreparedStatement pstmt = null;

    public static void main(String[] args) {
        try {
            conn = DruidUtils.getConnection();
            String sql = "insert into user(id, username, password) values (null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"sffddf");
            pstmt.setString(2,"dddffddf");
            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(conn,pstmt);
        }
    }
}
