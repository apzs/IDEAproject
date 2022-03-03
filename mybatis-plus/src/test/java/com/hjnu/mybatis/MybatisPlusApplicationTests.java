package com.hjnu.mybatis;

import com.hjnu.mybatis.mapper.UserMapper;
import com.hjnu.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

	@Autowired
	public UserMapper userMapper;

	@Test
	public void findAll(){
		//通过条件查询器查询一个List集合，条件查询器可以设置为null
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

	@Test
	public void select(){
		//根据id查询User对象
		User user = userMapper.selectById(4L);
		System.out.println(user);
		//根据id列表查询User
		List<Long> list = Arrays.asList(1L, 2L, 3L, 4L);
		userMapper.selectBatchIds(list);
	}

	@Test
	public void insert(){
		User user = new User(null, "wa", 21, "21832347@qq.com");
		System.out.println(user);
		//插入数据
		int res = userMapper.insert(user);
		System.out.println(res+" id:"+user.getId());
	}

	@Test
	public void delete(){
		//根据id删除
		int i1 = userMapper.deleteById(1499035990654713858L);
		System.out.println("result:"+ i1);
		//根据map删除
		Map<String, Object> map = new HashMap<>();
		map.put("name","wangwu");
		map.put("age",21);
		int i2 = userMapper.deleteByMap(map);
		System.out.println(i2);
		//根据id集合删除
		List<Long> list = Arrays.asList(1L, 2L, 3L);
		int i3 = userMapper.deleteBatchIds(list);
		System.out.println(i3);
	}

	@Test
	public void update(){
		//根据集合删除
		User user = new User(4L,"zhangsan",20,"22139@qq.com");
		int i = userMapper.updateById(user);
		System.out.println(i);
	}
}
