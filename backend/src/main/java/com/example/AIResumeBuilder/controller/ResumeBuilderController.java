package com.example.AIResumeBuilder.controller;

import com.example.AIResumeBuilder.service.LLMService;
import com.example.AIResumeBuilder.service.ResumeBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController // Marks this class as a Spring MVC Controller that handles HTTP requests and returns responses directly in JSON/XML format (instead of rendering views like Thymeleaf or JSP).
@RequestMapping("/api") // Defines the base URL path for all endpoints in this controller.
public class ResumeBuilderController{

    @Autowired // Automatically injects an instance of ResumeBuilderService into this controller.
    private ResumeBuilderService resumeBuilderService;
    @Autowired
    private LLMService llmService;

    @PostMapping("/generateResume") // Maps HTTP POST requests to /api/generateResume to this method.
    public ResponseEntity<?> generateResume(
            @RequestParam(value = "resumeFile", required = false) MultipartFile resumeFile,
            @RequestParam(value = "jdFile", required = false) MultipartFile jdFile,
            @RequestParam(value = "jdText", required = false) String jdText,
            @RequestParam(value = "instructions", required = true) String instructions
    ){
        try{
//            System.out.println(resumeFile);
//            System.out.println(jdFile);
//            System.out.println(jdText);
//            System.out.println(instructions);
            List<String> resJdInstruc = resumeBuilderService.processUserInput(resumeFile, jdFile, jdText, instructions);

            String llmPrompt = llmService.generatePrompt(resJdInstruc); // here we have the final prompt needed to create resume
//            System.out.println(llmPrompt);

            String generatedResume = llmService.createResume(llmPrompt);

            return ResponseEntity.ok().body(generatedResume);
        }
        catch(Exception e){
            return ResponseEntity.status(500).body("Failed to generate resume: " + e.getMessage());
        }
    }
}

