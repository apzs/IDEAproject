package com.hjnu.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjnu.mybatis.mapper.UserMapper;
import com.hjnu.mybatis.pojo.User;
import com.hjnu.mybatis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 无名氏
 * @date 2022/3/3
 * @Description: TODO
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
