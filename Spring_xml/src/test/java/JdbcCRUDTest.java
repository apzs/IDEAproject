import login.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcCRUDTest {

    @Autowired
    @Qualifier("jdbcTemplate")
    //不能加static
    private  JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        int i = jdbcTemplate.update("insert into accounts(name,account) values(? ,?) ", "lisa1", 1000);
        System.out.println(i);
    }

    @Test
    public void testDelete(){
        int i = jdbcTemplate.update("delete from accounts where name =?", "lisa1");
        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        int i = jdbcTemplate.update("update accounts set account=? where name =?", 1200, "lisa1");
        System.out.println(i);
    }

    @Test
    public void testQueryAll(){
        List<Account> query = jdbcTemplate.query("select * from accounts", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
    }

    @Test
    public void testQuery(){
        Account account = jdbcTemplate.queryForObject("select * from accounts where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "lisa1");
        System.out.println(account);
    }

    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from accounts", Long.class);
        System.out.println(count);
    }

    @Test
    public void testQueryCount2(){
        Long count = jdbcTemplate.queryForObject("select count(*) from accounts where name = ? ", Long.class,"lisa1");
        System.out.println(count);
    }
}
