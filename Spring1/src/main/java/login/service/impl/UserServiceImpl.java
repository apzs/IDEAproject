package login.service.impl;

import login.dao.UserDao;
import login.service.UserService;

/**
 * @author 无名氏
 * @Data 2021/7/17
 */
public class UserServiceImpl implements UserService {

    public UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
        System.out.println("save UserService ....");
    }
}
