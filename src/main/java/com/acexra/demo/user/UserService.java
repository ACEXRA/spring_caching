package com.acexra.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getALlUser(){
        System.out.print(userRepository.findAll());
        return userRepository.findAll();
    }
}
