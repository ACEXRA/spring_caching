package com.acexra.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<UserEntity> getAllUsers(){
        return userService.getALlUser();
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("/clearCache")
    public String clearCache(){
        return userService.clearCache();
    }
}
