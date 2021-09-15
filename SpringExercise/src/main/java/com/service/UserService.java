package com.service;

import com.domain.User;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);

    User login(User user1);
}
