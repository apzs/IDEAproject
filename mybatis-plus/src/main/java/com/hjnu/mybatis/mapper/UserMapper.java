package com.hjnu.mybatis.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjnu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Select("select * from mybatis_plus.t_user where uid = #{uid}")
    User findById(Long id);

    /**
     * xml方式查询大于该age的所有数据
     * @param age 年龄
     * @return
     */
    List<User> findByAge(int age);

    /**
     * 分页查询大于该age的数据
     * @param page 分页对象
     * @param age  年龄
     * @return
     */
    Page<User> findByPage2(Page<?> page, Integer age);
}
