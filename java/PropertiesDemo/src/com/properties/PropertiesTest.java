package com.properties;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * @author Jay
 * @time 2015Äê8ÔÂ10ÈÕ
 */
public class PropertiesTest {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("name", "jay");
		System.out.println(prop.getProperty("name"));
		Iterator<Entry<Object, Object>> it = prop.entrySet().iterator();
		while(it.hasNext()){
			Entry<Object, Object> entry = it.next();
			System.out.println(entry.getKey().toString() + "=" + entry.getValue());
		}
	}
}
