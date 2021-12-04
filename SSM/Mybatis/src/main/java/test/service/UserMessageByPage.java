package test.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.dao.UserMessageMapper;
import test.domain.UserMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/19
 */
public class UserMessageByPage {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMessageMapper mapper = sqlSession.getMapper(UserMessageMapper.class);

        //设置分页相关参数 当前页+分页显示的条数
        PageHelper.startPage(1,3);
        List<UserMessage> allMessage = mapper.findAllMessage();
        for (UserMessage userMessage : allMessage) {
            System.out.println(userMessage);
        }

        //获得与分页相关参数
        PageInfo<UserMessage> pageInfo = new PageInfo<UserMessage>(allMessage);
        System.out.println("当前页:" + pageInfo.getPageNum());
        System.out.println("每页显示条数:" + pageInfo.getPageSize());
        System.out.println("总条数:" + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("上一页:" + pageInfo.getPrePage());
        System.out.println("下一页:" + pageInfo.getNextPage());
        System.out.println("是否是第一页:" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页:" + pageInfo.isIsLastPage());

    }
}
