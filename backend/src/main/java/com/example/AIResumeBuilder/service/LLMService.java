package com.example.AIResumeBuilder.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LLMService{
    public String generatePrompt(List<String> resJdInstruc) {
        String resumeContent = resJdInstruc.get(0);
        String jdContent = resJdInstruc.get(1);
        String instructions = resJdInstruc.get(2);

        return createPrompt(resumeContent, jdContent, instructions);
    }

    private String createPrompt(String resumeContent, String jdContent, String instructions) {
        StringBuilder promptBuilder = new StringBuilder();

        // Opening instruction
        promptBuilder.append("I need you to create a professional resume tailored to the job description provided below.\n\n");

        // Add resume content if present
        if (resumeContent != null && !resumeContent.isEmpty()) {
            promptBuilder.append("CANDIDATE RESUME:\n");
            promptBuilder.append(resumeContent).append("\n\n");
        }

        // Add job description if present
        if (jdContent != null && !jdContent.isEmpty()) {
            promptBuilder.append("TARGET JOB DESCRIPTION:\n");
            promptBuilder.append(jdContent).append("\n\n");
        }

        // Add user instructions if present
        if (instructions != null && !instructions.isEmpty()) {
            promptBuilder.append("ADDITIONAL INSTRUCTIONS:\n");
            promptBuilder.append(instructions).append("\n\n");
        }

        // Enhanced output requirements with popular resume frameworks
        promptBuilder.append("OUTPUT REQUIREMENTS:\n");
        promptBuilder.append("1. Use popular resume frameworks like XYZ (Accomplished X as measured by Y by doing Z), CAR/PAR (Challenge-Action-Result), and STAR (Situation-Task-Action-Result) to craft impact-oriented bullet points.\n");
        promptBuilder.append("2. Structure the resume into clear sections: Contact Information, Professional Summary, Skills, Experience, Education, Certifications, Projects, and Additional Information.\n");
        promptBuilder.append("3. Quantify achievements with metrics (percentages, numbers, time saved) and start each bullet with strong action verbs.\n");
        promptBuilder.append("4. Tailor content by matching keywords and phrases from the job description to optimize for ATS screening.\n");
        promptBuilder.append("5. Use concise bullet points (max two lines), maintain consistent date formatting (e.g., MMM YYYY), and ensure reverse chronological order in Experience and Education.\n");
        promptBuilder.append("6. Keep the resume length appropriate: one page for early-career roles, two pages for senior positions, focusing on relevance.\n");
        promptBuilder.append("7. Ensure readability: choose standard fonts, use adequate white space, avoid graphics, tables, and complex layouts.\n");
        promptBuilder.append("8. Eliminate first-person pronouns; use clear, concise language.\n");
        promptBuilder.append("9. Provide consistent formatting for headings, bullet styles, and indentation.\n");
        promptBuilder.append("10. Include an optional 'Interests' or 'Additional Information' section to showcase cultural fit if space allows.\n\n");

        return promptBuilder.toString();
    }


    public String createResume(String llmPrompt) {
        // Call the LLM API with the prompt and get the generated resume
        // For now, let's just return a dummy response
        String generatedResume = "Generated Resume based on the provided prompt: " + llmPrompt;

        return generatedResume;
    }


}
