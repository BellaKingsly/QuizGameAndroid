/*
 Date: 02/07/2026
 Name: Bella
 File Path: controller/QuizController.java
 Function: REST controller that handles quiz-related API requests.
           It provides endpoints for retrieving quiz questions.
*/

package com.example.quiz_backend.controller;

import com.example.quiz_backend.dto.QuizQuestionDTO;
import com.example.quiz_backend.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 REST API controller for quiz system.
*/
@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public List<QuizQuestionDTO> getQuestions() {
        return service.getAllQuestions();
    }
}