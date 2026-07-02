/*
 Date: 02/07/2026
 Name: Bella
 File Path: entity/QuizQuestionEntity.java
 Function: Maps quiz question data from MySQL database using JPA.
*/

package com.example.quiz_backend.entity;

import jakarta.persistence.*;

// JPA entity: represents a row in the "questions" table
@Entity
@Table(name = "questions")
public class QuizQuestionEntity {

    // Primary key (auto-generated ID)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Question text
    @Column(nullable = false)
    private String question;

    // Multiple choice options
    @Column(name = "option_a", nullable = false)
    private String optionA;

    @Column(name = "option_b", nullable = false)
    private String optionB;

    @Column(name = "option_c", nullable = false)
    private String optionC;

    @Column(name = "option_d", nullable = false)
    private String optionD;

    // Correct answer index (0-3)
    @Column(nullable = false)
    private int answer;

    // Explanation for correct answer
    @Column(length = 1000)
    private String explanation;

    // Required by JPA (must exist)
    public QuizQuestionEntity() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // FIX: optional but useful for JPA/debugging
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}