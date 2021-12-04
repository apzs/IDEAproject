package test.dao2;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import test.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
public interface UserMapper2 {

    @Select(" select id,username,password from test.user")
    List<User> findAll() throws IOException;

    @Select(" select id,username,password from test.user where id=#{id}")
    User findUserById(int id);

    @Insert(" insert into test.user(id, username, password) VALUES(#{id},#{username},#{password})")
    void save(User user);

    @Update(" update test.user set username=#{username},password=#{password} where id=#{id}")
    void update(User user);

    @Delete("delete from test.user where id=#{id}")
    void delete(int id);
}
