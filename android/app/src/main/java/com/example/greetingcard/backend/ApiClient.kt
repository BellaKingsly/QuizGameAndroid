/*
 Date: 02/07/2026
 Name: Bella
 File Path: backend / ApiClient
 Function: Retrofit API client for backend communication
*/

package com.example.greetingcard.backend

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    // Use centralized config for base URL
    private val retrofit: Retrofit by lazy {

        // Create Retrofit instance
        Retrofit.Builder()

            // Set API base URL
            .baseUrl(ApiConfig.BASE_URL)

            // Convert JSON to Kotlin objects
            .addConverterFactory(GsonConverterFactory.create())

            // Build Retrofit object
            .build()
    }

    // API service instance
    val api: ApiService by lazy {

        // Create implementation of ApiService
        retrofit.create(ApiService::class.java)
    }
}