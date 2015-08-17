#JDBC

	Java Data Base Connectivity（java数据库连接）
	
	maven构建项目，引入架包
	
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.36</version>
	</dependency>
	
	
##使用处理器查找
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
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}

##使用预处理器查找
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
				// 3.创建预处理器
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
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
##ResouceBundle
	可以解决国际化问题

