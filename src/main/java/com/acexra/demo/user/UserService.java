package com.acexra.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users")
    public Page<UserEntity> getALlUser(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @CachePut(value = "users", key="#user.id")
    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    public Optional<UserEntity> getUserById(String id){
        return userRepository.findById(id);
    }

    public void deleteUser(String id){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        userEntity.ifPresent(user -> userRepository.delete(user));
    }

    @CacheEvict(value = "users",allEntries = true)
    public String clearCache(){
        return "Cache cleared";
    }
}
