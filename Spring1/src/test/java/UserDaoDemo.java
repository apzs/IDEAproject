import login.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 无名氏
 * @Data 2021/7/16
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
//      ApplicationContext app2= new FileSystemXmlApplicationContext("B:\\IDEAproject\\Spring1\\src\\main\\resources\\applicationContext.xml");
        UserDao userDao =(UserDao) app.getBean("userDao");
//      UserDao userDao2 =(UserDao) app.getBean(UserDaoImpl.class);
        userDao.save();
    }
}
