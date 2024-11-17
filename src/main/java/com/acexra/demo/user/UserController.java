package com.acexra.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    public Page<UserEntity> getAllUsers(@RequestParam(defaultValue = "0")int page,
                                        @RequestParam(defaultValue = "10")int size){
        Pageable pageable = PageRequest.of(page,size);
        return userService.getALlUser(pageable);
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/clearCache")
    public String clearCache(){
        return userService.clearCache();
    }
}
