package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import org.testng.annotations.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 无名氏
 * @Data 2021/6/29
 */
public class BeanUtilsTest {
    @Test
    public void test1(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select username,password from user where id = ?";
        //只能为一行数据
        Map<String, Object> map = template.queryForMap(sql, 1);
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
