package com.pluto.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pluto.service.iface.HelloService;

/**
 * @author       Jay
 * @time         2015年7月17日
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class HelloServiceImplTest {

//	@Autowired
//	HelloService helloService;
	
	//private ApplicationContext context;
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	}
	
	@After
	public void close(){
		context.destroy();
	}
	
	@Test
	public void testHello() {
		System.out.println(context);
		HelloService helloService = (HelloService)context.getBean("helloServiceImpl");
		System.out.println(helloService.hello("Jay"));
	}

}
