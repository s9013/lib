package com.mongo.util;

import com.google.gson.GsonBuilder;


/**
 * print util
 * @author       Jay
 * @time         2015年7月24日
 */
public class PrintUtil {
	
	/**
	 * 打印方法
	 * @param obj
	 */
	public static void print(Object obj){
		System.out.println("********************************************************");
		System.out.println(new GsonBuilder().serializeNulls().create().toJson(obj));
		System.out.println("********************************************************");
	}
}
