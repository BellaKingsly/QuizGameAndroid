package com.example.greetingcard.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.greetingcard.backend.QuizQuestion

@Composable
fun ReviewScreen(
    questions: List<QuizQuestion>,
    history: List<Int>,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            "Answer Review",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        questions.forEachIndexed { i, q ->

            Card {

                Column(
                    Modifier.padding(16.dp)
                ) {

                    Text(q.question)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "Your Answer: ${
                            q.options.getOrNull(
                                history.getOrNull(i) ?: -1
                            ) ?: "Not Answered"
                        }"
                    )

                    Text(
                        "Correct Answer: ${q.options[q.answer]}"
                    )

                    Text(
                        "Explanation: ${q.explanation}"
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back Home")
        }
    }
}