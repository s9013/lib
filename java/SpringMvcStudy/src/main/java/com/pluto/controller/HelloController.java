package com.pluto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author       Jay
 * @time         2015��7��20��
 */
@RestController
@RequestMapping(value="api")
public class HelloController {

	@RequestMapping(value="hello")
	public String hello(){
		return "hello wolrd";
	}
	
}
