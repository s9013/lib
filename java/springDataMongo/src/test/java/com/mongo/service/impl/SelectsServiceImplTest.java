package com.mongo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.SpringDataMongoApplication;

import com.mongo.entity.Selects;
import com.mongo.service.iface.SelectsService;
import com.mongo.util.PrintUtil;


/**
 * @author       Jay
 * @time         2015年7月24日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDataMongoApplication.class)
public class SelectsServiceImplTest {

	@Autowired
	SelectsService service;
	
	@Test
	public void testAdd() {
		service.add();
	}
	
	@Test
	public void testFind() {
		 Selects selects = service.findById("55b201ddbfe72a9287f101c3");
		 PrintUtil.print(selects);
	}

}
