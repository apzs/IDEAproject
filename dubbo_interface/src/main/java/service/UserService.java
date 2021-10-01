package service;

import com.pojo.User;

/**
 * @author 无名氏
 * @date 2021/9/29
 */
public interface UserService {

    /**
     * 测试
     * @return
     */
    public String sayHello();

    /**
     * 查询user
     * @param id
     * @return
     */
    public User findUserById(int id);
}
