package dao;

import domain.User;

import java.util.List;

/**
 * @Data:2021/6/26
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 根据用户名删除用户
     * @param name
     */
    public void deleteUser(String name);

    /**
     * 根据id修改用户名
     * @param id
     * @param user
     */
    public void setUser(int id,User user);

    /**
     * 根据姓名修改用户名
     * @param name
     * @param user
     */
    public void setUser(String name,User user);

    /**
     * 根据用户名获取用户对象
     * @param name
     * @return
     */
    public User getUser(String name);

    /**
     * 根据id获取用户对象
     * @param id
     * @return
     */
    public User getUser(int id);


    /**
     * 查询所有用户信息
     * @return 用户组成的list集合
     */
    public List<User> findAllUser();

    /**
     * 查询用户名是否存在
     * @param name 用户的用户名
     * @return
     */
    public boolean isUserExist(String name);

    /**
     * 判断用户名和密码是否正确
     * @param loginUser
     * @return 返回用户id
     */
    public User login(User loginUser);

}
