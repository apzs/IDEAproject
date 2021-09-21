package com.mapper;

import com.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
@Repository
@Mapper
public interface UserMapper {
    @Select("select * from test.user")
    List<User> findAll();
}