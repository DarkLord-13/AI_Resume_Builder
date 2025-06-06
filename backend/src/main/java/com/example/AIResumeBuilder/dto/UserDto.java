package com.example.AIResumeBuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto{
    private String name;
    private String email;
    private String chatId;
    private String chatHistory;
}
