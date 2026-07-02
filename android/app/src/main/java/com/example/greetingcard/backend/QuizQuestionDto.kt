/*
 Date: Latest 02/07/2026
 Name: Bella
 File Path: backend/QuizQuestionDto
 Function: Data model representing a quiz question received from backend
*/

package com.example.greetingcard.backend

// Data class for quiz question response from API
data class QuizQuestionDto(
    val id: Long,                  // Question ID
    val question: String,          // Question text
    val options: List<String>,     // Multiple choice options
    val answer: Int,               // Correct answer index
    val explanation: String        // Explanation of the correct answer
)