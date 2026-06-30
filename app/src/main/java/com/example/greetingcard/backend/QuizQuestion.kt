package com.example.greetingcard.backend

// Quiz question data model
data class QuizQuestion(
    val id: Int,
    val question: String,
    val options: List<String>,
    val answer: Int,
    val explanation: String
)