package com.service.impl;

import com.dao.RoleDao;
import com.dao.UserDao;
import com.domain.Role;
import com.domain.User;
import com.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

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

    @Override
    public void save(User user, Long[] roleIds) {
//        向sys_user表中存数据
        Long userId = userDao.save(user);
//        向sys_user_role表中存多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
        //删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
        //删除sys_user表
        userDao.del(userId);
    }

    @Override
    public User login(User user1) {
        try {
            User user =  userDao.login(user1);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
