package com.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.entity.Selects;
import com.mongo.service.iface.SelectsService;


/**
 * @author       Jay
 * @time         2015年7月24日
 */
@RestController
@RequestMapping(value="api/selects")
public class SelectsController {

	@Autowired
	SelectsService selectsService;
	
	@RequestMapping(value="get")
	Selects get(@RequestParam(value="id")String id){
		return selectsService.findById(id);
	}
	
}
