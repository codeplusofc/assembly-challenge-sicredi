package com.votation.api.controller;

import com.votation.api.entity.UserEntity;
import com.votation.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserEntity postUser(@RequestBody UserEntity userEntity) {
        return userService.postUser(userEntity);
    }


}
