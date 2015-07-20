package com.pluto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author       Jay
 * @time         2015Äê7ÔÂ20ÈÕ
 */
@RestController
@RequestMapping(value="api")
public class HelloController {

	@RequestMapping(value="hello")
	public String hello(){
		return "hello wolrd";
	}
	
}
