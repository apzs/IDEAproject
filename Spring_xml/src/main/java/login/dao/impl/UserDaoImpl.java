package login.dao.impl;

import login.dao.UserDao;

/**
 * @author 无名氏
 * @Data 2021/7/16
 */
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @Override
    public void save() {
        System.out.println("save UserDao...");
    }

   public void init(){
       System.out.println("初始化方法...");
   }

    public void destroy(){
        System.out.println("销毁方法...");
    }

}
