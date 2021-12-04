package test;

import dao.UserMessageDao;
import dao.impl.UserMessageDaoImpl;
import domain.UserMessage;
import org.junit.Test;

import java.util.List;

/**
 * @author 无名氏
 * @Data 2021/6/30
 */
public class UserMessageDaoTest {
    @Test
    public void test1(){
        UserMessageDao umDao =new UserMessageDaoImpl();
        List<UserMessage> userMessages = umDao.findAllUserMessage();
        for (UserMessage userMessage : userMessages) {
            System.out.println(userMessage);
        }
    }
}
