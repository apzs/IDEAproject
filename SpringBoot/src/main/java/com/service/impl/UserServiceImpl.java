package com.service.impl;

import com.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add...");
    }
}
