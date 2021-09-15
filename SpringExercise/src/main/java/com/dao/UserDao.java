package com.dao;

import com.domain.User;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public interface UserDao {
    public List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);

    User login(User user1);
}
