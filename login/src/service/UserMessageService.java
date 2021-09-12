package service;

import domain.PageBean;
import domain.UserMessage;

import java.util.Map;

/**
 * @author 无名氏
 * @Data 2021/7/2
 */
public interface UserMessageService {
    /**
     * 添加用户信息
     * @param userMessage
     * @return
     */
    public void addUserMessage(UserMessage userMessage);

    /**
     * 删除用户信息
     * @param id
     */
    public void deleteUserMessage(int[] id);

    /**
     * 根据id回写数据到userMessage.jsp
     * @param id
     * @return
     */
    public  UserMessage searchUserMessage(int id);

    /**
     * 查询
     * @param currentPage 当前页
     * @param rows 当前页有几行
     * @return
     */
    PageBean<UserMessage> searchUsersMessageByPage(String currentPage, String rows, Map<String, String[]> condition);
}
