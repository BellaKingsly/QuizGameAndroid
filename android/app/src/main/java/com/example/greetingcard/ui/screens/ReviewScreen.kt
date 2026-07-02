/*
 Date: 24/06/2026
 Name: Bella
 File Path: ui/screens/ReviewScreen
 Function: Displays detailed review of all quiz questions including user answers,
           correct answers, and explanations in a scrollable list.
*/

package com.example.greetingcard.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.greetingcard.backend.QuizQuestionDto

@Composable
fun ReviewScreen(
    questions: List<QuizQuestionDto>, // List of all quiz questions
    history: List<Int>,               // User answer history (-1 = not answered)
    onBack: () -> Unit                // Navigate back to home screen
) {

    // Scrollable main container
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        // Screen title
        Text(
            "Answer Review",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Loop through all questions and display review info
        questions.forEachIndexed { i, q ->

            // Card for each question review
            Card {

                Column(
                    Modifier.padding(16.dp)
                ) {

                    // Question text
                    Text(q.question)

                    Spacer(modifier = Modifier.height(8.dp))

                    // User's selected answer (or "Not Answered")
                    Text(
                        "Your Answer: ${
                            q.options.getOrNull(
                                history.getOrNull(i) ?: -1
                            ) ?: "Not Answered"
                        }"
                    )

                    // Correct answer display
                    Text(
                        "Correct Answer: ${q.options[q.answer]}"
                    )

                    // Explanation for learning purpose
                    Text(
                        "Explanation: ${q.explanation}"
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        // Back button to return home
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back Home")
        }
    }
}