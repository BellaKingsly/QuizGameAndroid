/*
 Date: 02/07/2026
 Name: Bella
 File Path: service/QuizService.java
 Function: Service layer that handles quiz logic between Controller and Repository.
*/

package com.example.quiz_backend.service;

import com.example.quiz_backend.dto.QuizQuestionDTO;
import com.example.quiz_backend.entity.QuizQuestionEntity;
import com.example.quiz_backend.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 This class contains business logic for quiz questions.
 It connects Controller (API layer) and Repository (database layer).
*/

@Service
public class QuizService {

    // Repository used to access database
    private final QuizRepository repository;

    // Constructor injection (Spring automatically provides repository)
    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    // Get all quiz questions from database
    public List<QuizQuestionDTO> getAllQuestions() {

        // Step 1: Get all data from database
        return repository.findAll()

                // Step 2: Convert each Entity into DTO
                .stream()
                .map(this::toDTO)

                // Step 3: Collect results into a list
                .toList();
    }

    // Convert database Entity into DTO for frontend use
    private QuizQuestionDTO toDTO(QuizQuestionEntity e) {

        return new QuizQuestionDTO(
                e.getId(),           // Question ID
                e.getQuestion(),     // Question text

                // Convert 4 options into a list
                List.of(
                        e.getOptionA(),
                        e.getOptionB(),
                        e.getOptionC(),
                        e.getOptionD()
                ),

                e.getAnswer(),        // Correct answer index
                e.getExplanation()    // Explanation for answer
        );
    }
}