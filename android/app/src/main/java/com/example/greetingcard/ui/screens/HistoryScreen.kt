/*
 Date: 22/06/2026
 Name: Bella
 File Path: ui/screens/HistoryScreen
 Function: Displays quiz answer history, showing user's selected answers
           compared with correct answers, and provides navigation options.
*/

package com.example.greetingcard.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.greetingcard.backend.QuizQuestionDto

@Composable
fun HistoryScreen(
    questions: List<QuizQuestionDto>, // List of quiz questions
    answers: List<Int>,              // User answers history (-1 = timeout)
    onBack: () -> Unit,              // Navigate back to home screen
    onRestart: () -> Unit            // Restart quiz game
) {

    // Main container layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Top navigation buttons (Home / Restart)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Back to Home screen button
            Button(
                onClick = { onBack() },
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text("Home")
            }

            // Restart quiz button
            Button(
                onClick = { onRestart() },
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text("Restart")
            }
        }

        // Screen title
        Text("Answer History")

        // Display each question with user answer and correct answer
        questions.forEachIndexed { i, q ->

            // Get user's answer safely (null if not answered)
            val userAnswer = answers.getOrNull(i)

            // Question text
            Text("Q${i + 1}: ${q.question}")

            // User's selected answer (or N/A if invalid / timeout)
            Text(
                "Your Answer: ${
                    q.options.getOrNull(userAnswer ?: -1) ?: "N/A"
                }"
            )

            // Correct answer display
            Text("Correct: ${q.options[q.answer]}")

            // Space between questions for better readability
            Spacer(Modifier.height(10.dp))
        }
    }
}