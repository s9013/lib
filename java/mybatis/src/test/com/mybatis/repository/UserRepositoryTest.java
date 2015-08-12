package com.mybatis.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.entity.User;
import com.mybatis.mapper.IUserMapper;

/**
 * @author       Jay
 * @time         2015年8月10日
 */
public class UserRepositoryTest {

	SqlSession sqlSession;
	
	IUserMapper mapper;
	
	@Before
	public void init(){
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = getClass().getClassLoader().getResourceAsStream("conf.xml");
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建能执行映射文件中sql的sqlSession
		sqlSession = sessionFactory.openSession(true);
		mapper = sqlSession.getMapper(IUserMapper.class);
	}
	
	@Test
	public void testAddUser() {
		mapper.add(new User("火星2", 21));
	}

	@Test
	public void testFindById() {
		mapper.update(new User(11, "叮当猫", 11));
	}

	@Test
	public void testFindAll() {
		List<User> list = mapper.getAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testDelete() {
		int i = mapper.delete(14);
		System.out.println(i);
	}
	
}
