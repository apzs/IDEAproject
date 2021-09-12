import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 无名氏
 * @date 2021/9/9
 */

public class JdbcTemplateTest {
//
//  @Autowired
//  @Qualifier("jdbcTemplate")
//    public static JdbcTemplate jdbcTemplate;
      /*
    static {
        jdbcTemplate = new JdbcTemplate();
        Properties pro = new Properties();
        try {
            pro.load(JdbcTemplate.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
            jdbcTemplate.setDataSource(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    @Test
    public  void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        int i = jdbcTemplate.update("insert into accounts(name,account) values(? ,?) ", "lisa5", 1000);
        System.out.println(i);
    }

}
