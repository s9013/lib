package com.pluto.dao;

import org.springframework.stereotype.Repository;


/**
 * hello repository
 * @author       Jay
 * @time         2015��7��23��
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
