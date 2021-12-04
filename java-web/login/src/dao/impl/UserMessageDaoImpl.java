package dao.impl;


import dao.UserMessageDao;
import domain.UserMessage;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 无名氏
 * @Data 2021/6/30
 */
public class UserMessageDaoImpl implements UserMessageDao {

    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addUserMessage(UserMessage userMessage) {
        String sql = "insert into userMessage values (?,?,?,?,?,?,?)";
        template.update(sql, userMessage.getId(), userMessage.getName(), userMessage.getGender(), userMessage.getTel(),
                userMessage.getQq(), userMessage.getE_mail(), userMessage.getAddress());
    }

    @Override
    public void deleteUserMessage(int id) {
        String s = "delete from userMessage where id=?";
        template.update(s, id);
    }

    @Override
    public void setUserMessage(UserMessage userMessage) {
        String sql = "update userMessage set name=?,gender=?,tel=?,qq=?,e_mail=?,address=? where id=?";
        template.update(sql, userMessage.getName(), userMessage.getGender(), userMessage.getTel(),
                userMessage.getQq(), userMessage.getE_mail(), userMessage.getAddress(), userMessage.getId());
    }

    @Override
    public UserMessage getUserMessage(int id) {
        UserMessage userMessage = null;
        try {
            //1，编写sql
            String sql = "select * from userMessage where id = ?";
            //2.调用queryForObject方法
            userMessage = template.queryForObject(sql, new BeanPropertyRowMapper<UserMessage>(UserMessage.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return userMessage;
    }

    @Override
    public List<UserMessage> findAllUserMessage() {
        //编写sql
        String sql = "select * from userMessage";
        //存入list集合
        List<UserMessage> userMessages = template.query(sql, new BeanPropertyRowMapper<UserMessage>(UserMessage.class));
        return userMessages;
    }

    @Override
    public boolean isUserMessageExist(int id) {
        long a = 0;
        try {
            //1，编写sql
            String sql = "select count(*) from userMessage where id = ?";
            //2.调用query方法
            a = (long) template.queryForObject(sql, Long.class, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return a != 0;
    }

    @Override
    public UserMessage searchUserMessage(int id) {
        UserMessage userMessage = null;
        try {
            String sql = "select * from userMessage where id=?";
            userMessage = template.queryForObject(sql, new BeanPropertyRowMapper<UserMessage>(UserMessage.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return userMessage;
    }

    @Override
    public int searchUserMessageCount(Map<String, Object[]> condition) {
        int a = 0;
        try {
            //1.定义模板sql
            String sql = "select count(*) from userMessage where 1 = 1";
            //2.拼接条件
            Set<String> keySet = condition.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                if (condition.get(next)==null || condition.get(next).length==0){
                    a = (int) template.queryForObject(sql, Integer.class);
                }else {
                    a = (int) template.queryForObject(sql+next, Integer.class,condition.get(next));
                }
                break;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<UserMessage> searchUsersMessageByPage(int start, int row, Map<String, Object[]> condition) {
        //1.定义模板sql
        String sqlStart = "select * from userMessage where 1 = 1";
        String sqlEnd = " limit ?,?";
        List<UserMessage> userMessages = null;
        //2.拼接条件
        Set<String> keySet = condition.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (condition.get(next)==null || condition.get(next).length==0){
               userMessages = template.query(sqlStart+sqlEnd, new BeanPropertyRowMapper<UserMessage>(UserMessage.class), start, row);
            }else {
                Object[] param = condition.get(next);
                int len = param.length;
                Object[] o = new Object[len+2];
                for (int i = 0; i < len; i++) {
                    o[i] = param[i];
                }
                o[len] = start;
                o[len+1] = row;
                userMessages = template.query(sqlStart+next+sqlEnd, new BeanPropertyRowMapper<UserMessage>(UserMessage.class),o);
            }
            break;
        }
        return userMessages;
    }
}
