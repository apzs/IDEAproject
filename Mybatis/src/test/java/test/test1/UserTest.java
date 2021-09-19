package test.test1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import test.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/17
 */
public class UserTest {

    @Test
    public void findAll() throws IOException {
        //获得核心配置环境
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数: namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void findUserById() throws IOException {
        //获得核心配置环境
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数: namespace+id
        User user = sqlSession.selectOne("userMapper.findUserById", 7);
        System.out.println(user);
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void insert() throws IOException {
        User user = new User("lisa", "123456");
        //获得核心配置环境
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数: namespace+id
        sqlSession.insert("userMapper.save", user);
        //MyBatis执行更新操作 提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        User user = new User("tom", "123456");
        user.setId(2);
        //获得核心配置环境
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        //参数设置为true表示自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作  参数: namespace+id
        sqlSession.update("userMapper.update", user);
        //openSession已经开启提交
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void delete() throws IOException {
        //获得核心配置环境
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数: namespace+id
        sqlSession.delete("userMapper.delete", 2);
        //MyBatis执行更新操作 提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}
