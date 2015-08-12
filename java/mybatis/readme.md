http://mybatis.github.io/mybatis-3/zh/index.html

1.创建maven项目
 项目右击 properties --> java build path --> source
	
2.pom中导入mybaties mysel-connection-java jar

	<dependency>
		<groupId>org.mybatis</groupId>
		<artifactId>mybatis</artifactId>
		<version>3.3.0</version>
	</dependency>
	
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.36</version>
	</dependency>
		
3.
create database mybatis;
use mybatis;
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
INSERT INTO users(NAME, age) VALUES('Jay', 27);
INSERT INTO users(NAME, age) VALUES('Mike', 27);

注解方式

配置文件

ref http://www.cnblogs.com/xdp-gacl/p/4261895.html