package com.mongo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.entity.Selects;
import com.mongo.repository.SelectsRepository;
import com.mongo.service.iface.SelectsService;

/**
 * @author Jay
 * @time 2015-7-24
 */
@Service(value="selectsService")
public class SelectsServiceImpl implements SelectsService {

	@Autowired
	SelectsRepository selectsRepository;
	
	public void add() {
		Selects s = new Selects();
		s.setName("Jay");
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("Javascript");
		s.setSkills(list);
		selectsRepository.save(s);
	}

	@Override
	public Selects findById(String id) {
		return selectsRepository.findOne(id);
	}
	
}
