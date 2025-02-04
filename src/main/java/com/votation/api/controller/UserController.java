package com.votation.api.controller;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.entity.UserEntity;
import com.votation.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Get a list of all users", description = "Return a list of all existent users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User list successfully returned")
    })
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Find a user by it`s id", description = "Return the user with the searched id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully returned"),
            @ApiResponse(responseCode = "404", description = "User with searched id not found")
    })
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "Post new user", description = "Add a new user to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User added successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, name is required")
    })
    @PostMapping
    public UserEntity postUser(@RequestBody UserEntity userEntity) {
        return userService.postUser(userEntity);
    }


}
