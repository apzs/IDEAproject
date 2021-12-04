package com.dao.impl;

import com.dao.UserDao;
import com.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from test.sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long save(User user) {
        //创建PreparedStatementCreator
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into test.sys_user(id,username,email,password,phoneNum) values (?,?,?,?,?)",
                        //生成主键
                        PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };

        //创建KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        long userId = keyHolder.getKey().longValue();
//        jdbcTemplate.update("insert into sys_user(username,email,password,phoneNum) values (?,?,?,?)"
//                ,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into test.sys_user_role(userId,roleId) values (?,?)", userId, roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from test.sys_user_role where userId=?", userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from test.sys_user where id=?", userId);
    }

    @Override
    public User login(User user1) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from test.sys_user where username=? and password=?",
                new BeanPropertyRowMapper<User>(User.class),
                user1.getUsername(), user1.getPassword());
        return user;
    }
}
