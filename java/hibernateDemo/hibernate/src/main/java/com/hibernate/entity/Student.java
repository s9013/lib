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
	
	private Grade grade;

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

	// public int getGid() {
	// return gid;
	// }
	//
	// public void setGid(int gid) {
	// this.gid = gid;
	// }

	public Student() {
		super();
	}

	public Student(int sid, String sname, String sex) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	@Override
	public String toString() {
		return "name:" + sname + "班级 " + grade.getGname() + "班级描述：" + grade.getGdesc();
	}

}
