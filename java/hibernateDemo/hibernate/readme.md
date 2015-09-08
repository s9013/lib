title: Hibernate1
date: 2015-08-28 13:49:49
tags:
- Hibernate
---

Hibernate是一个开放源代码的对象关系映射框架，它对JDBC进行了非常轻量级的对象封装，使得Java程序员可以随心所欲的使用对象编程思维来操纵数据库。
<!--more-->

hibernate 
	配置
	工程模式
	实体类 mapping 数据库中的表
	使用JDBC是手动去转换


1.hibernate.cfg.xml 配置文件
  数据库驱动、url、用户名、密码、方言、显示sql、格式化sql、建表策略
2.实体类 映射配置 domainName.hbm.xml
  id 生成策略
3.hibernateUtil 
  Configuration 获取sessiongFactory 获取session 
4.CURD
  开启事务





使用Maven构将 pom.xml文件
~~~XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>hibernate</groupId>
	<artifactId>hibernate</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>hibernate</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.0.0.Final</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.36</version>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
	</dependencies>
</project>

~~~


----------


##hibernate配置文件 hibernate.cfg.xml src/main/resources 路径下##

~~~xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

	<session-factory>

		<!-- Database connection settings -->
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="connection.url">jdbc:mysql://localhost:33060/test</property>
		<property name="connection.username">root</property>
		<property name="connection.password">root</property>

		<!-- JDBC connection pool (use the built-in) -->
		<property name="connection.pool_size">1</property>

		<!-- SQL dialect -->
		<property name="dialect">org.hibernate.dialect.MySQLDialect</property>

		<!-- Enable Hibernate's automatic session context management -->
		<property name="current_session_context_class">thread</property>

		<!-- Disable the second-level cache -->
		<property name="cache.provider_class">org.hibernate.cache.internal.NoCacheProvider</property>

		<!-- Echo all executed SQL to stdout -->
		<property name="show_sql">true</property>

		<!-- Format SQL -->
		<property name="format_sql">true</property>

		<!-- Drop and re-create the database schema on startup -->
		<property name="hbm2ddl.auto">update</property>

		<mapping resource="com/hibernate/entity/User.hbm.xml" />

	</session-factory>

</hibernate-configuration>
~~~

----------


##User.java
~~~java
package com.hibernate.entity;

import java.util.Date;

/**
 * @author Jay
 */
public class User {
	private int id;
	private String name;
	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
~~~

----------

##User映射配置文件 src/main/resources/com.hibernate.entity 路径下
~~~xml
<hibernate-mapping package="com.hibernate.entity">

    <class name="User" table="User">
        <id name="id" column="user_id"/>
        <property name="name"/>
        <property name="birthday"/>
    </class>

</hibernate-mapping>
~~~

----------

##测试
~~~java
package com.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.User;

/**
 * @author Jay
 */
public class UserTest {
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
        //加载主配置
        conf.configure("/hibernate.cfg.xml");
        //获取SessionFactory
        SessionFactory sf = conf.buildSessionFactory();
        //获取Session
        Session session = sf.openSession();
        //开启事务
        Transaction transction = session.beginTransaction();
        //执行添加操作
        User user = new User();
        user.setId(5);
        user.setName("Jay");
        user.setBirthday(new Date());
        session.save(user);
        //提交事务
        transction.commit();
        //关闭session
        session.close();
	}

}
~~~

----------



##一对多
创建两张表 班级表  学生表
~~~sql
--班级表
create table grade
(
	gid int primary key,
	gname varchar(20) not null,
	gdesc varchar(50)
);
--学生表
create table student
(
	sid int primary key,
	sname varchar(20) not null,
	sex char(2),
	gid int
);
--外键
alter table student add constraint fk_student_gid foreign key(gid) references grade(gid);
~~~

entity
~~~java
package com.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Jay
 * @time 2015年9月8日
 */
public class Grade implements Serializable {

	private static final long serialVersionUID = -2845032978967274285L;

	private int gid;
	private String gname;
	private String gdesc;

	private Set<Student> students;
	
	
	public Grade() {
		super();
	}

	public Grade(int gid, String gname, String gdesc) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}

~~~

~~~java
package com.hibernate.entity;

import java.io.Serializable;

/**
 * @author Jay
 * @time 2015年9月8日
 */
public class Student implements Serializable {

	private static final long serialVersionUID = -2005812841024253872L;

	private int sid;
	private String sname;
	private String sex;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student() {
		super();
	}

	public Student(int sid, String sname, String sex) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
	}

}
~~~

##配置文件
~~~xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

<hibernate-mapping package="com.hibernate.entity">

	<!-- name是类名 table是表名 -->
	<class name="Grade" table="grade">

		<!-- name是类的地段 column是表里的字段 -->
		<id name="gid" column="gid">
			<!-- 主键生成策略 -->
			<generator class="native" />
		</id>

		<property name="gname" />
		<property name="gdesc" />

		<!-- 一对多 -->
		<set name="students" table="student">
			<key column="gid" />
			<one-to-many class="com.hibernate.entity.Student" />
		</set>
	</class>

</hibernate-mapping>
~~~

~~~xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

<hibernate-mapping package="com.hibernate.entity">

	<!-- name是类名 table是表名 -->
    <class name="Student" table="student">
    	
    	<!-- name是类的地段 column是表里的字段 -->
        <id name="sid" column="sid">
        	<!-- 主键生成策略 -->
        	<generator class="native"/>
        </id>
        
        <property name="sname"/>
        <property name="sex"/>
        <!-- 一对多  -->
        <!-- <many-to-one name="gid" foreign-key="gid"/> -->
    </class>

</hibernate-mapping>
~~~

##测试
~~~java
package com.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hibernate.entity.Grade;
import com.hibernate.util.HibernateUtil;

/**
 * @author       Jay
 * @time         2015年9月8日
 */
public class More2one {

	
	private Gson gson = new GsonBuilder().serializeNulls().create();
	
	@Test
	public void test() {
		Session session = null;
        try {
			session = HibernateUtil.getSession();
			Grade grade =  session.get(Grade.class, 2);
			System.out.println(gson.toJson(grade));
		} finally {
			if(session != null){
				session.close();
			}
		}
	}

}
~~~
		输出结果
				Hibernate: 
				    select
				        grade0_.gid as gid1_0_0_,
				        grade0_.gname as gname2_0_0_,
				        grade0_.gdesc as gdesc3_0_0_ 
				    from
				        grade grade0_ 
				    where
				        grade0_.gid=?
				Hibernate: 
				    select
				        students0_.gid as gid4_1_0_,
				        students0_.sid as sid1_1_0_,
				        students0_.sid as sid1_1_1_,
				        students0_.sname as sname2_1_1_,
				        students0_.sex as sex3_1_1_ 
				    from
				        student students0_ 
				    where
				        students0_.gid=?
				{"gid":2,"gname":"javascript","gdesc":"js强化班","students":[{"sid":3,"sname":"Mike","sex":"男"}]}



参考：
	1.http://docs.jboss.org/hibernate/orm/5.0/manual/en-US/html/ch01.html#