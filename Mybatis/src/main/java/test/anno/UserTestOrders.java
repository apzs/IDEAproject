package test.anno;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import test.dao2.OrderMapper2;
import test.dao2.RoleMapper;
import test.domain.Orders;
import test.domain.User_Orders;
import test.domain.User_Role;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
public class UserTestOrders {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        //获得核心配置环境
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void findAll() throws IOException {
        OrderMapper2 mapper = sqlSession.getMapper(OrderMapper2.class);
        List<Orders> ordersList = mapper.findAllOrders();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
        sqlSession.close();
    }

    @Test
    public void findAll2() throws IOException {
        OrderMapper2 mapper = sqlSession.getMapper(OrderMapper2.class);
        List<Orders> ordersList = mapper.findAllOrders2();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
        sqlSession.close();
    }

    @Test
    public void findOrdersByUsers() throws IOException {
        OrderMapper2 mapper = sqlSession.getMapper(OrderMapper2.class);
        List<User_Orders> userOrders = mapper.findOrdersByUsers();
        for (User_Orders userOrder : userOrders) {
            System.out.println(userOrder);
        }
        sqlSession.close();
    }

    @Test
    public void FindUserList() throws IOException {
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<User_Role> usersList = mapper.findUsersList();
        for (User_Role user_role : usersList) {
            System.out.println(user_role);
        }
        sqlSession.close();
    }

}
