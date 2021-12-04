package com.service.impl;

import com.dao.RoleDao;
import com.domain.Role;
import com.service.RoleService;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
