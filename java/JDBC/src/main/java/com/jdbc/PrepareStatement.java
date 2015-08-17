package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatement {
	public static void main(String[] args) {
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33060/test", "root", "root");
			// 3.创建预处理器（防止注入）
			CallableStatement callableStatement = connection.prepareCall("select id,name,age from users where id = ?");
			//   占位符赋值
			callableStatement.setInt(1, 1);
			// 4.执行 获取结果集
			ResultSet rs = callableStatement.executeQuery();
			// 5.循环获取结果
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id: " + id + " name: " + name + " age: " + age);
			}
			// 6. 关闭
			rs.close();
			callableStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
