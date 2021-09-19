package test.dao;

import test.domain.UserMessage;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public interface UserMessageMapper {

    void save(UserMessage userMessage);

    List<UserMessage> findAllMessage();

    UserMessage findMessageById(int id);
}
