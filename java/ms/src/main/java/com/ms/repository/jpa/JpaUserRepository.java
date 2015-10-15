package com.ms.repository.jpa;

import com.ms.entity.jpa.User2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jay on 2015/9/22.
 */
public interface JpaUserRepository extends CrudRepository<User2, Integer> {

    List<User2>  findAll();

}
