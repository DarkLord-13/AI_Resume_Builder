package com.example.AIResumeBuilder.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LLMService{
    public String createPrompt(List<String> resJdInstruc) {
        String resumeContent = resJdInstruc.get(0);
        String jdContent = resJdInstruc.get(1);
        String instructions = resJdInstruc.get(2);

        // Create a prompt for the LLM
        // make the prompt better
        String prompt = "Resume: " + resumeContent + "\n" +
                        "Job Description: " + jdContent + "\n" +
                        "Instructions: " + instructions;

        return prompt;
    }

    public String createResume(String llmPrompt) {
        // Call the LLM API with the prompt and get the generated resume
        // For now, let's just return a dummy response
        String generatedResume = "Generated Resume based on the provided prompt: " + llmPrompt;

        return generatedResume;
    }
}
