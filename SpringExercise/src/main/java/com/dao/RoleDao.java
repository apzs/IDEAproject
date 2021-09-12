package com.dao;

import com.domain.Role;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleById(Long id);
}
