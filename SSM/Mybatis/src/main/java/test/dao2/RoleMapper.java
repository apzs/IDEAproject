package test.dao2;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import test.domain.Role;
import test.domain.User_Role;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
public interface RoleMapper {
    @Select("select id,roleName as 'name',roleDesc as 'desc' " +
            " from test.sys_role join test.sys_user_role " +
            "on userId =#{uid} and sys_role.id = sys_user_role.roleId")
        List<Role> findRolesByUid(int uid);

//=======================================================================================================\\

    @Select("select id,username,password from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "test.dao2.RoleMapper.findRolesByUid")
            )
    })
    List<User_Role> findUsersList();
}
