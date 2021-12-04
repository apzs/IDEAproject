package test.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.dao.UserMessageMapper;
import test.domain.UserMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public class UserMessageDemo {
    public static void main(String[] args) throws IOException {
        UserMessage userMessage = new UserMessage();
        userMessage.setName("lisa");
        userMessage.setBirthday(new Date());

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMessageMapper mapper = sqlSession.getMapper(UserMessageMapper.class);
        mapper.save(userMessage);
        sqlSession.commit();

        UserMessage userMessage1 = mapper.findMessageById(4);
        System.out.println(userMessage1);
    }
}
