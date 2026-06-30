package com.example.greetingcard.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.greetingcard.backend.QuizQuestion

@Composable
fun HistoryScreen(
    questions: List<QuizQuestion>,
    answers: List<Int>,
    onBack: () -> Unit,
    onRestart: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Top buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Back to Home
            Button(
                onClick = { onBack() },
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text("Home")
            }

            // Restart quiz
            Button(
                onClick = { onRestart() },
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text("Restart")
            }
        }

        Text("Answer History")

        questions.forEachIndexed { i, q ->

            val userAnswer = answers.getOrNull(i)

            Text("Q${i + 1}: ${q.question}")

            Text(
                "Your Answer: ${
                    q.options.getOrNull(userAnswer ?: -1) ?: "N/A"
                }"
            )

            Text("Correct: ${q.options[q.answer]}")

            Spacer(Modifier.height(10.dp))
        }
    }
}