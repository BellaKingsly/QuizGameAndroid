package com.example.greetingcard.backend

data class GameState(
    val score: Int = 0,
    val coins: Int = 0,
    val currentQuestion: Int = 0
)