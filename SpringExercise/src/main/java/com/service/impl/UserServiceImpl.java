package com.service.impl;

import com.dao.RoleDao;
import com.dao.UserDao;
import com.domain.Role;
import com.domain.User;
import com.service.UserService;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roles = roleDao.findRoleById(id);
            user.setRoles(roles);
        }
        return userList;
    }
}
