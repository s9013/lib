package com.pluto.dao;

import org.springframework.stereotype.Repository;


/**
 * hello repository
 * @author       Jay
 * @time         2015Äê7ÔÂ23ÈÕ
 */
@Repository(value="helloRepository")
public class HelloRepository {

	/**
	 * save
	 * @param str
	 */
	public void save(String str){
		System.out.println("save " + str);
	}
	
}
