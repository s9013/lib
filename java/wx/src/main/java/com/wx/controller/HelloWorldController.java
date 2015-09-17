package com.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jay
 */
@Controller
@RequestMapping("/api")
public class HelloWorldController {

	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "helloWorld";
	}

	@RequestMapping("/helloWorld2")
	@ResponseBody
	public String helloWorld2() {
		return "helloWorld2222222222";
	}



	@RequestMapping(value = "do",method = RequestMethod.GET)
	public String doGet() {
		return "doGet";
	}
}

