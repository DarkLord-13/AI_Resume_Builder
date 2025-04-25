package com.example.AIResumeBuilder.controller;

import com.example.AIResumeBuilder.service.ResumeBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController // Marks this class as a Spring MVC Controller that handles HTTP requests and returns responses directly in JSON/XML format (instead of rendering views like Thymeleaf or JSP).
@RequestMapping("/api") // Defines the base URL path for all endpoints in this controller.
public class ResumeBuilderController{

    @Autowired // Automatically injects an instance of ResumeBuilderService into this controller.
    private ResumeBuilderService resumeBuilderService;

    @PostMapping("/uploadResume") // Maps HTTP POST requests to /api/uploadResume to this method.
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file){
        try{
            String result = resumeBuilderService.handleResumeUpload(file);
            return ResponseEntity.ok().body("Resume uploaded successfully: " + result);
        }
        catch (Exception e){
            return ResponseEntity.status(500).body("Error uploading resume: " + e.getMessage());
        }
    }
}

