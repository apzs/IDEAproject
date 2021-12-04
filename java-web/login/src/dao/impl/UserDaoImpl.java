package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @author 无名氏
 * @Data:2021/6/26
 */
public class UserDaoImpl implements UserDao {
public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addUser(User user) {
        String sql = "insert into user(id, username, password) values (null,?,?)";
        template.update(sql, user.getUsername(), user.getPassword());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public void deleteUser(String name){
        String sql = "delete from user where username = ?";
        template.update(sql,name);
    }

    @Override
    public User getUser(String name) {
        User user = null;
        try {
            //1，编写sql
            String sql = "select id,username,password from user where username = ?";
            //2.调用queryForObject方法
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class), name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        try {
            //1，编写sql
            String sql = "select id,username,password from user where id = ?";
            //2.调用queryForObject方法
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAllUser() {
        //编写sql
        String sql = "select id,username,password from user";
        //存入list集合
        List<User>  users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void setUser(int id,User user){
        String sql ="update user set username = ? , password = ? where id = ?";
        template.update(sql,user.getUsername(),user.getPassword(),id);
    }

    @Override
    public void setUser(String name,User user){
        String sql ="update user set username = ? , password = ? where username = ?";
        template.update(sql,user.getUsername(),user.getPassword(),name);
    }



    @Override
    public boolean isUserExist(String name) {
        long a = 0;
        try {
            //1，编写sql
            String sql = "select count(*) from user where username = ?";
            //2.调用query方法
            a =(long) template.queryForObject(sql,Long.class, name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return a!= 0;
    }


    @Override
    public User login(User loginUser) {
       User user = null;
        try {
            //1，编写sql
            String sql = "select id,username,password from user where username = ? and password = ?";
            //2.调用query方法
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}
