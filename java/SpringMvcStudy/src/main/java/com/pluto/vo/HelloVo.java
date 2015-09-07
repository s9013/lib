package com.pluto.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author       Jay
 * @time         2015Äê7ÔÂ23ÈÕ
 */
public class HelloVo implements Serializable {

	private static final long serialVersionUID = 3164062608679545696L;
	
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;

	private String str;
	
	

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}
	
	
	

}
