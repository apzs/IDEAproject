package com.service;

import com.domain.Role;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public interface RoleService {

    public List<Role> list();

    public void save(Role role);
}
