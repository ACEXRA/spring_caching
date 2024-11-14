package com.acexra.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users")
    public List<UserEntity> getALlUser(){
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @CachePut(value = "users", key="#user.id")
    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    public Optional<UserEntity> getUserById(String id){
        return userRepository.findById(id);
    }

    @CacheEvict(value = "users",allEntries = true)
    public String clearCache(){
        return "Cache cleared";
    }
}
