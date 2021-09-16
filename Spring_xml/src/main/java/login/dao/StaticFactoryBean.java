package login.dao;

import login.dao.impl.UserDaoImpl;

/**
 * @author 无名氏
 * @Data 2021/7/17
 */
public class StaticFactoryBean {
    public static UserDao createUserDao1(){
        return new UserDaoImpl();
    }

    public UserDao createUserDao2(){
        return new UserDaoImpl();
    }
}
