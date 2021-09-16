import login.config.SpringConfiguration;
import login.dao.UserDao;
import login.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    DataSource dataSource;

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        System.out.println(dataSource);
    }

    @Test
    public void test1(){
        userService.save();
    }
}
