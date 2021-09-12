package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import org.junit.Test;

/**
 * @Data:2021/5/17
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        UserDao dao = new UserDaoImpl();
        User user = dao.login(user1);
        System.out.println(user);
    }
}
