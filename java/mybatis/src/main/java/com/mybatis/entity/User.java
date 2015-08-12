package com.mybatis.entity;

/**
 * @author Jay
 * @time 2015年8月7日
 */
public class User {
	// 实体类的属性和表的字段名称一一对应
	private int id;
	private String name;
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id:" + this.getId() + " , name: " + this.name + " , age: " + this.age + "]";
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
