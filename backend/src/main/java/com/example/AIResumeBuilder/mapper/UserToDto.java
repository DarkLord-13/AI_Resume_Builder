package com.example.AIResumeBuilder.mapper;

import com.example.AIResumeBuilder.dto.UserDto;
import com.example.AIResumeBuilder.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserToDto{

    public UserDto mapToDto(UserEntity user){
        return new UserDto(
                user.getName(),
                user.getEmail(),
                user.getChatId() != null ? user.getChatId().toString() : null,
                user.getChatHistory()
        );
    }
}