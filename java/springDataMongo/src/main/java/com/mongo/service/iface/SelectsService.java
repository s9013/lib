package com.mongo.service.iface;

import com.mongo.entity.Selects;

/**
 * @author Jay
 * @time 2015��7��24��
 */
public interface SelectsService {
	
	void add();
	
	
	Selects findById(String id);
}
