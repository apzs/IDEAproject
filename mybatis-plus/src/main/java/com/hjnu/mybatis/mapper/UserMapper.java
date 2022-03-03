package com.hjnu.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjnu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 无名氏
 * @date 2022/3/2
 * @Description: TODO
 */
@Repository
//@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 自定义查询方法
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User findById(Long id);
}
