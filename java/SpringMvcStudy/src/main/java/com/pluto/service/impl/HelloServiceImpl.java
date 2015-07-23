package com.pluto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluto.dao.HelloRepository;
import com.pluto.service.iface.HelloService;

/**
 * Created by Jay on 2015/7/17.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Autowired
	private HelloRepository helloRepository;
	
    public String hello(String str) {
    	helloRepository.save(str);
        return "This is service :" + str ;
    }

}
