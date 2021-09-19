package test.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.dao.UserMapper;
import test.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/18
 */
public class UserConditionSearch {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setId(7);
        user.setUsername("lisa");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findByCondition(user);
        System.out.println(users);
    }

}
