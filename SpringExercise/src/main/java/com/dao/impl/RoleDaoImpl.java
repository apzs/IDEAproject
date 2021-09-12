package com.dao.impl;

import com.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public class RoleDaoImpl implements com.dao.RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        System.out.println(jdbcTemplate);
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role(roleName,roleDesc) values(?,?)",role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleById(Long id) {
        List<Role> roles = jdbcTemplate.query(" select roleName " +
                                                  " from (select roleId from sys_user_role where userId=?) as rid " +
                                                  " join sys_role as sr " +
                                                  "on rid.roleId = sr.id"
                                            ,new BeanPropertyRowMapper<Role>(Role.class),id);
        return roles;
    }
}
