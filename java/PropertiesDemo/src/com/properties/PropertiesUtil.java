package com.properties;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * @author Jay
 * @time 2015年8月7日
 */
public class PropertiesUtil {

	public Map<String, String> load() {
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream in = getClass().getResourceAsStream("properties.properties");
			props.load(in);
			Iterator<Entry<Object, Object>> it = props.entrySet().iterator();
			while(it.hasNext()){
				Entry<Object, Object> entry = it.next();
				map.put(entry.getKey().toString(),entry.getValue().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public void getAll(){
		Map<String, String> map = load();
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println( entry.getKey() + " = "+ entry.getValue());
		}
	}
	
	public String getByKey(String key){
		Map<String, String> map = load();
		return map.get(key);
	}
	
	public static void main(String[] args) {
		PropertiesUtil util = new PropertiesUtil();
		// 获取所有
		util.getAll();
		
		// 根据key获取value
		System.out.println(util.getByKey("b"));
	}

}
