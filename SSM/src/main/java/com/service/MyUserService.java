package com.service;


import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 无名氏
 * @date 2021/11/21
 * @Description: TODO
 */
public class MyUserService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //模拟数据库中的用户数据
    public Map<String, User> map = new HashMap<>();

    public void initData() {
        User user1 = new User();
        user1.setUsername("zhang");
        user1.setPassword(bCryptPasswordEncoder.encode("1234"));

        User user2 = new User();
        user2.setUsername("li");
        user2.setPassword(bCryptPasswordEncoder.encode("1234"));

        map.put(user1.getUsername(), user1);
        map.put(user2.getUsername(), user2);
    }

    /**
     * 根据用户名加载用户信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        initData();
        System.out.println(bCryptPasswordEncoder.encode("admin"));
        System.out.println(bCryptPasswordEncoder.encode("1234"));
        //模拟根据用户名查询数据库
        User userInDB = map.get(username);
        if (userInDB == null) {
            return null;
        }
        //模拟数据库中的密码，后期需要查询数据库 {noop}表示明文加密
        //  String password = "{noop}" + userInDB.getPassword();
        String password = userInDB.getPassword();
        //授权，后期需要改为查询数据库动态获得用户拥有的权限和角色
        List<GrantedAuthority> list = new ArrayList<>();
        if (username.equals("zhang")){
            list.add(new SimpleGrantedAuthority("add"));
            //list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(username, password, list);
        return user;
    }
}
