package test;

import dao.UserMessageDao;
import dao.impl.UserMessageDaoImpl;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * @author 无名氏
 * @Data 2021/7/3
 */
public class DeleteUserMessage {
    UserMessageDao u = new UserMessageDaoImpl();
    @Test
    public void test1(){
        String s = "delete from userMessage where id=888";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        int update = jdbcTemplate.update(s);
        System.out.println(update);
    }
}
