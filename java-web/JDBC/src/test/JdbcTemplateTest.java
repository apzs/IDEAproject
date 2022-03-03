package test;

import org.testng.annotations.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.DruidUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Data:2021/6/13
 */
public class JdbcTemplateTest {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDateSource());
    @Test
    public void test1(){
        String sql = "insert into user(id, username, password) values (null,?,?)";
        int i = template.update(sql, "dfdw", "edfgg");
        System.out.println(i);
    }
    @Test
    public void test2(){
        String sql = "select * from user where id = ?";
        //只能为一行数据
        Map<String, Object> map = template.queryForMap(sql, 1);
        User  user = new User();
//        BeanUtils.populate(user,map);
        System.out.println(map);
    }

    @Test
    public void test3(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String,Object> map: maps) {
            System.out.println(map);
        }
    }

    @Test
    public void test4(){
        String sql = "select * from user";
        List<User> users = template.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt(1);
                String username = rs.getString("username");
                String password = rs.getString("password");
                return new User(id, username, password);
            }
        });

        for (User user : users) {
            System.out.println(user);
        }
    }

    /*

     */
    @Test
    public void test5(){
        String sql = "select * from user";
        //执行query语句User对象必须有空构造器
        //只有设set方法后才能赋值，不能使用构造器传参赋值
        //如果有空值基本的int等类型不能赋值为null应该为他们的对象即Integer等
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test6(){
        //查询多条数据
        String sql = "select * from user";
        List<User2> users = template.query(sql, new BeanPropertyRowMapper<User2>(User2.class));
        for (User2 user : users) {
            System.out.println(user);
        }
    }

    @Test
    //查询一条数据
    public void test7(){
        String sql = "select * from user where id = ?";
        User2 user = template.queryForObject(sql,new BeanPropertyRowMapper<User2>(User2.class),1);
        System.out.println(user);
    }

    @Test
    public void test8(){
        //查询结果个数
        String sql = "select count(id) from user";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}
