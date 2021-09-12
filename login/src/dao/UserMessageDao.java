package dao;

import domain.UserMessage;

import java.util.List;
import java.util.Map;

/**
 * @author 无名氏
 * @Data 2021/6/29
 */
public interface UserMessageDao {
    /**
     * 添加用户信息
     * @param userMessage
     */
    public void addUserMessage(UserMessage userMessage);

    /**
     * 删除用户时,根据id删除用户信息
     * @param id
     */
    public void deleteUserMessage(int id);

    /**
     * 根据id修改用户信息
     * @param userMessage
     */
    public void setUserMessage(UserMessage userMessage);

    /**
     * 根据用户id获取用户对象
     * @param id
     * @return
     */
    public UserMessage getUserMessage(int id);

    /**
     * 查询所有用户信息
     * @return 用户组成的list集合
     */
    public List<UserMessage> findAllUserMessage();

    /**
     * 查询用户信息是否存在
     * @param id
     * @return
     */
    public boolean isUserMessageExist(int id);

    /**
     * 据id查找用户信息
     * @param id
     * @return
     */
    public UserMessage searchUserMessage(int id);

    /**
     * 查询用户信息数量
     * @param condition
     * @return
     */
    public int searchUserMessageCount(Map<String,Object[]> condition);

    /**
     * 根据开始索引查询指定行数的用户信息
     * @param start
     * @param row
     * @param condition
     * @return
     */
    public List<UserMessage> searchUsersMessageByPage(int start,int row,Map<String,Object[]> condition);
}
