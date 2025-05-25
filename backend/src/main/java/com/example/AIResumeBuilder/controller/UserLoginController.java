package com.example.AIResumeBuilder.controller;

import com.example.AIResumeBuilder.dto.UserDto;
import com.example.AIResumeBuilder.dto.UserLoginDto;
import com.example.AIResumeBuilder.entity.UserEntity;
import com.example.AIResumeBuilder.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserLoginController{

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity user){
        try{
            userService.registerUser(user.getName(), user.getEmail(), user.getPassword());
            return ResponseEntity.status(201).body("User registered successfully");
        }
        catch(Exception e){
            return ResponseEntity.status(500).body("Failed to register user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto user){
        try{
            userService.loginUser(user.getEmail(), user.getPassword());
            return ResponseEntity.status(200).body("User logged in successfully");
        }
        catch(Exception e){
            return ResponseEntity.status(401).body("Login failed: " + e.getMessage());
        }
    }
}
