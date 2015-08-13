package com.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author       Jay
 * @time         2015-8-12
 */
@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Integer age;

	public User(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public User(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "id:" + this.getId() + " name: " + this.name + " age: " + this.age;
	}

	public User(Integer id) {
		this.id = id;
	}
	
	
	
}
