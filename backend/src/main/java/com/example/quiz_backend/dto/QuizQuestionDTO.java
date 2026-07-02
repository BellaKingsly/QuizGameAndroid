/*
 Date: 02/07/2026
 Name: Bella
 File Path: dto/QuizQuestionDTO.java
 Function: Data Transfer Object (DTO) used to represent a quiz question
           and send it between backend and frontend.
*/

package com.example.quiz_backend.dto;

import java.util.List;

/*
 This class defines the structure of a quiz question
 returned by the API to the Android application.
*/

public class QuizQuestionDTO {

    private Long id;                 // Question ID
    private String question;         // Question text
    private List<String> options;    // Multiple choice options
    private int answer;              // Correct answer index
    private String explanation;      // Answer explanation

    // Constructor
    public QuizQuestionDTO(Long id, String question, List<String> options, int answer, String explanation) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
    }

    // Get question ID
    public Long getId() {
        return id;
    }

    // Get question text
    public String getQuestion() {
        return question;
    }

    // Get answer options
    public List<String> getOptions() {
        return options;
    }

    // Get correct answer index
    public int getAnswer() {
        return answer;
    }

    // Get explanation for answer
    public String getExplanation() {
        return explanation;
    }
}