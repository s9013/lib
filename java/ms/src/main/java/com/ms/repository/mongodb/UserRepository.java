package com.ms.repository.mongodb;

import com.ms.entity.mongodb.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Jay on 2015/9/23.
 */
public interface UserRepository  extends PagingAndSortingRepository<User, String> {


}
