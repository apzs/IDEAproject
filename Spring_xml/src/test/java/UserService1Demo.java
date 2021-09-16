import login.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author 无名氏
 * @Data 2021/7/17
 */
public class UserService1Demo {
    public static void main(String[] args) {
        ApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userDao =(UserService) app.getBean("userService");
        userDao.save();
    }
}
