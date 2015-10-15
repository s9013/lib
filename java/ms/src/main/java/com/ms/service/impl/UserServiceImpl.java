package com.ms.service.impl;

import com.ms.entity.jpa.User2;
import com.ms.entity.mongodb.User;
import com.ms.repository.jpa.JpaUserRepository;
import com.ms.repository.mongodb.UserRepository;
import com.ms.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jay on 2015/9/23.
 */
@Service("userServcie")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JpaUserRepository jpaUserRepository;


    public User getUserById(String id) {
        User user = null;
       user = userRepository.findOne(id);
        return user;
    }

    public void addUser(User user) {
        user =  userRepository.save(user);
        System.out.print(user);
    }

    public User2 getUserByIdJpa(int id) {
        return  jpaUserRepository.findOne(id);
    }
}
