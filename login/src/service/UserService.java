package service;

import domain.User;

import java.util.List;

/**
 * @Data:2021/6/26
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     * @return 如果用户名存在，则返回false
     */
    public boolean add(User user);
}
