/*
 Date: Latest 02/07/2026
 Name: Bella
 File Path: backend/ApiService
 Function: Defines API endpoints for network requests
*/

package com.example.greetingcard.backend

import retrofit2.http.GET

interface ApiService {

    // GET request to fetch quiz questions from backend
    @GET("api/quiz/questions")
    suspend fun getQuestions(): List<QuizQuestionDto>
}