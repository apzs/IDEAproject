package Demo;

import utls.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Data:2021/6/13
 */
public class JdbcDemo4_事务 {

    private static Connection conn = null;
    private static PreparedStatement pstmt1 = null;
    private static PreparedStatement pstmt2 = null;

    public static void main(String[] args) {
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //开启事务(设置为false)
            conn.setAutoCommit(false);
            String sql1 = "update user set user.account =user.account-?  where id = ?";
            String sql2 = "update user set user.account =user.account+?  where id = ?";
            //预编译sql语句
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);

            pstmt1.executeUpdate();
            //手动制造异常
            int i = 3/0;
            pstmt2.executeUpdate();
            //提交事务
            conn.commit();

        } catch (Exception e) {
            if (conn != null) {
                try {
                    //回滚事务
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pstmt1);
            JDBCUtils.close(null,pstmt2);
        }
    }
}
