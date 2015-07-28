package com.pluto.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluto.service.iface.HelloService;


/**
 * @author       Jay
 * @time         2015Äê7ÔÂ20ÈÕ
 */
@Controller
@RequestMapping(value="/api")
public class HelloController {

	Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	HelloService helloService; 
	
	@RequestMapping(value="hello")
	@ResponseBody
	public String hello(@RequestParam(value="name") String name){
		log.info("hello");
		
		String str = helloService.hello(name);
		return "hello:" + str;
	}
	
	@RequestMapping(value="hellojsp")
	public String helloJsp(@RequestParam(value="name") String name,Model model){
		log.info("hellojsp");
		String str = helloService.hello(name);
		model.addAttribute("hello", str);
		return "hello";
	}
	
}
