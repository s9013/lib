package com.pluto.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pluto.service.iface.HelloService;


/**
 * @author       Jay
 * @time         2015��7��20��
 */
@RestController
@RequestMapping(value="/api")
public class HelloController {

	Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	HelloService helloService; 
	
	@RequestMapping(value="hello")
	public String hello(@RequestParam(value="name") String name){
		log.info("hello");
		
		String str = helloService.hello(name);
		return "hello:" + str;
	}
	
}
