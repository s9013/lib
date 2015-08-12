package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.entity.User;

/**
 * @author       Jay
 * @time         2015年8月10日
 */
public interface IUserMapper {

     @Insert("insert into users(name, age) values(#{name}, #{age})")
     public int add(User user);
	
     @Update("update users set name=#{name},age=#{age} where id=#{id}")
     public int update(User user);
	
     @Select("select * from users")
     public List<User> getAll();
     
     @Delete("delete from users where id=#{id}")
     public int delete(int id);
}
