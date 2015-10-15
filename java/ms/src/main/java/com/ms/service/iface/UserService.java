package com.ms.service.iface;

import com.ms.entity.jpa.User2;
import com.ms.entity.mongodb.User;

/**
 * Created by Jay on 2015/9/23.
 */
public interface UserService {

    /**
     * get user by id
     * @param id
     * @return
     */
    public User getUserById(String id);


    /**
     * add User2
     * @param user
     */
    public void addUser(User user);


    /**
     * get user by id
     * @param id
     * @return
     */
    public User2 getUserByIdJpa(int id);

}
