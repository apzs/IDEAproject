package test;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * @author 无名氏
 * @Data 2021/6/28
 */
public class CheckRepeatDemo {
    public static JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void checkRepeat() {
        String name = "eadffddfaf";
        Long along = Long.valueOf(0);
        try {
            //1，编写sql
            String sql = "select count(*) from user where username = ?";
            //2.调用query方法
            along = template.queryForObject(sql,Long.class, name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(along);
    }
}
