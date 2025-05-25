package com.example.AIResumeBuilder.service;

import com.example.AIResumeBuilder.controller.ChatController;
import com.example.AIResumeBuilder.dto.UserDto;
import com.example.AIResumeBuilder.entity.UserEntity;
import com.example.AIResumeBuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AIResumeBuilder.mapper.UserToDto;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatController chatController;

    @Autowired
    private UserToDto userToDto;

    public void registerUser(String name, String email, String password){
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }

        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
    }

    public void loginUser(String email, String password){
        UserEntity user = userRepository.findByEmail(email);
        if(user == null || !user.getPassword().equals(password)){
            throw new IllegalArgumentException("Invalid email or password");
        }
    }

    public UserDto getUserByEmail(String email){
        UserEntity user = userRepository.findByEmail(email);
        if(user == null){
            throw new IllegalArgumentException("User not found");
        }
        
        UserDto userDto = userToDto.mapToDto(user);
        return new UserDto(user.getName(), user.getEmail(), user.getChatId().toString(), user.getChatHistory());
    }
}
