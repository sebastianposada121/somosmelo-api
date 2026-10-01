package com.somosmelo.api.users.service;

import com.somosmelo.api.users.model.User;
import com.somosmelo.api.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> GetUsers(){
        return userRepository.findAll();
    }

}
