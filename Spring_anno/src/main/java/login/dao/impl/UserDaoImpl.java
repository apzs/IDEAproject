package login.dao.impl;

import org.springframework.stereotype.Repository;
import login.dao.UserDao;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}
