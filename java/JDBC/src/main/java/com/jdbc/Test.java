package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test 
{
    public static void main( String[] args ){
	   try {
	    	// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33060/test", "root", "root");
			// 3.创建处理器
			Statement statement =  connection.createStatement();
			// 4.执行 获取结果集
			ResultSet  rs = statement.executeQuery("select id,name,age from users where id = 10");
			// 5.循环获取结果
			while (rs.next()) {
				int id =  rs.getInt("id");
				String name =  rs.getString("name");
				int age =  rs.getInt("age");
				System.out.println("id: " + id + " name: " + name + " age: " + age);
				System.out.println(rs.getString(2));
			}
			
			// 6. 关闭
			rs.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
