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
