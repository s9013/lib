package com.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Map.Entry;

public class Test3 
{
    public static void main( String[] args ){
	   try {
		   // 加载配置文件
		   Test3 test = new Test3();
		   Map<String, String> map = test.load();
		   
	    	// 1.加载驱动
			Class.forName(map.get("driver"));
			// 2.获取连接
			Connection connection = DriverManager.getConnection(map.get("url"), map.get("username"), map.get("password"));
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
    
    public Map<String, String> load() {
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream in = getClass().getResourceAsStream("config.properties");
			props.load(in);
			Iterator<Entry<Object, Object>> it = props.entrySet().iterator();
			while(it.hasNext()){
				Entry<Object, Object> entry = it.next();
				map.put(entry.getKey().toString(),entry.getValue().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
