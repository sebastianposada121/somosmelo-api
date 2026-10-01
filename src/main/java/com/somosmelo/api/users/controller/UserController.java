package com.somosmelo.api.users.controller;

import com.somosmelo.api.users.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.somosmelo.api.users.model.User;
import java.util.Collections;
import java.util.List;
import com.somosmelo.api.users.dto.UserResponse;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> GetUsers(){
        try{
            List<User> users = userService.GetUsers();
            return users.stream().map(user -> {
                var newUser = new UserResponse();
                newUser.setId(user.getId());
                newUser.setName(user.getName());
                newUser.setLastname(user.getLastname());
                return newUser;
            }).toList();

        } catch(Exception e){
            System.err.println("error" + e.getMessage());
            return Collections.emptyList();
        }
    }
}
