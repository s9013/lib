package com.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.entity.User;

/**
 * @author Jay
 * @time 2015年8月7日
 */
public class AppTest {

	@Test
	public void test() {
		// mybatis的配置文件
		String resource = "conf.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = App.class.getClassLoader().getResourceAsStream(
				resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession(true);
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
//		String statement = "com.mybatis.entity.User.getUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
//		User user = session.selectOne(statement, 2);
//		System.out.println(user);
//		String statement = "com.mybatis.entity.User.delete";// 映射sql的标识字符串
//		int retResult = session.delete(statement, 2);
//		session.commit();
//		session.close();
//		System.out.println(retResult);
//		
//		String statement1 = "com.mybatis.entity.User.add";
//		int retResult1 = session.insert(statement1, new User("tony", 21));
//		System.out.println(retResult);
//		
//		session.commit();
//		session.close();
		
		//session.update("com.mybatis.entity.User.update",new User(11,"王",20));
		
//		// 根据id查找
//		User u = session.selectOne("com.mybatis.entity.User.getById", 11);
//		System.out.println(u);
		
		List<Object> list = session.selectList("com.mybatis.entity.User.getAll");
		for (Object obj : list) {
			System.out.println((User)obj);
		}
	}

}
