package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * @author 无名氏
 * @Data:2021/6/26
 */

public class UserServiceImpl implements UserService {
    public UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAllUser();
    }

    @Override
    public boolean add(User user) {
        boolean flag = ! dao.isUserExist(user.getUsername());
        if (flag){
            dao.addUser(user);
        }
        return flag;
    }
}