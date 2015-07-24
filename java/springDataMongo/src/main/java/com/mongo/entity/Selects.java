package com.mongo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author       Jay
 * @time         2015��7��24��
 */
@Document(collection="Selects")
public class Selects implements Serializable {

	private static final long serialVersionUID = -871636916039589707L;

	@Id
	private String id;
	private String name;
	private java.util.List<String> skills;

	public Selects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.List<String> getSkills() {
		return skills;
	}

	public void setSkills(java.util.List<String> skills) {
		this.skills = skills;
	}
	
	
}
