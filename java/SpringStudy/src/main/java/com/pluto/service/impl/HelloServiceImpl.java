package com.pluto.service.impl;

import org.springframework.stereotype.Service;

import com.pluto.service.iface.HelloService;

/**
 * Created by Jay on 2015/7/17.
 */
@Service("helloServiceImpl")
public class HelloServiceImpl implements HelloService {

    public String hello(String str) {
        return "Hello " + str + ", I am spring!";
    }

}
