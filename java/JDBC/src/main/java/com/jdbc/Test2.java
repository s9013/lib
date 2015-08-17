package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Test2 
{
    public static void main( String[] args ){
	   try {
		   // 加载配置文件
		   ResourceBundle bundle = ResourceBundle.getBundle("config");
		   String driver = bundle.getString("driver");
		   String url = bundle.getString("url");
		   String username = bundle.getString("username");
		   String password = bundle.getString("password");
		   
	    	// 1.加载驱动
			Class.forName(driver);
			// 2.获取连接
			Connection connection = DriverManager.getConnection(url, username, password);
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
