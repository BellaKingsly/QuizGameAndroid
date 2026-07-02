/*
 Date: 02/07/2026
 Name: Bella
 File Path: QuizBackendApplication.java
 Function: Main entry point of the Spring Boot backend application.
           It starts the server and initializes all Spring components.
*/

package com.example.quiz_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 This annotation enables:
 - Spring Boot autoConfiguration
 - Component scanning
 - Application setup
*/
@SpringBootApplication

public class QuizBackendApplication {

	// Main method: starts the backend server
	public static void main(String[] args) {
		SpringApplication.run(QuizBackendApplication.class, args);
	}
}