package login.service.impl;


import login.dao.UserDao;
import login.domain.User;
import login.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author 无名氏
 * @Data 2021/7/17
 */
public class UserServiceImpl2 implements UserService {

    private String company;
    private int age;
    private UserDao userDao;
    private Properties properties;
    private List<String> list;
    private List<User> list2;
    private Map<String,User> map;

    public void setAge(int age) {
        this.age = age;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setList2(List<User> list2) {
        this.list2 = list2;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public void save() {
        System.out.println(company + "===" + age);
        System.out.println(userDao);
        System.out.println(properties);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(map);
        userDao.save();
        System.out.println("save UserService ....");
    }
}
