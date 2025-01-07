package com.votation.api.controller;

import com.votation.api.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public UserEntity getUser() {
        UserEntity user = new UserEntity();

        user.setNome("Rafael");

        return user;
    }
}
