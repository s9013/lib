package com.mongo.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mongo.entity.Selects;


/**
 * @author       Jay
 * @time         2015��7��24��
 */
public interface SelectsRepository extends PagingAndSortingRepository<Selects, Serializable> {

}
