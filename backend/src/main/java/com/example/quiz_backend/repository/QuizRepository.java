/*
 Date: 02/07/2026
 Name: Bella
 File Path: repository/QuizRepository.java
 Function: Repository interface used to access quiz question data from the database.
*/

package com.example.quiz_backend.repository;

import com.example.quiz_backend.entity.QuizQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 This interface provides built-in database operations
 such as find, save, update, and delete.
*/

public interface QuizRepository extends JpaRepository<QuizQuestionEntity, Long> {
    // No extra code needed, Spring Data JPA provides default methods
}