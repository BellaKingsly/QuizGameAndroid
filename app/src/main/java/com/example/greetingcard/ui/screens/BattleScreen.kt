/* Kotlin
 Date: Date: 02/07/2026
 Name: Bella
 File Path: ui/screens/BattleScreen
 Function: Main quiz battle screen that handles question display, timer,
           scoring system, user interaction, and game result flow.
*/

package com.example.greetingcard.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.R
import com.example.greetingcard.backend.QuizQuestionDto
import com.example.greetingcard.ui.components.GameCard
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun BattleScreen(
    questions: List<QuizQuestionDto>,          // List of quiz questions from backend
    onFinish: (score: Int, coins: Int, history: List<Int>) -> Unit, // Called when quiz ends
    onQuit: () -> Unit,                        // Navigate back to home screen
    onRestart: () -> Unit                      // Restart the quiz game
) {

    // Current question index
    var index by remember { mutableIntStateOf(0) }

    // User score and coins
    var score by remember { mutableIntStateOf(0) }
    var coins by remember { mutableIntStateOf(0) }

    // Currently selected answer
    var selected by remember { mutableStateOf<Int?>(null) }

    // Store answer history (-1 means timeout)
    val history = remember { mutableStateListOf<Int>() }

    // Countdown timer per question
    var timeLeft by remember { mutableIntStateOf(20) }

    // Dialog states
    var showDialog by remember { mutableStateOf(false) }
    var showSubmitDialog by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }

    // Control timer loop state
    var isActive by remember { mutableStateOf(true) }

    // Show loading UI if no questions loaded
    if (questions.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    // Finish game when all questions are completed
    if (index >= questions.size) {
        onFinish(score, coins, history.toList())
        return
    }

    // Current question object
    val question = questions[index]

    // Timer logic for each question
    LaunchedEffect(index) {

        isActive = true
        timeLeft = 20
        selected = null
        showDialog = false

        // Countdown loop
        while (timeLeft > 0 && selected == null && isActive) {
            delay(1.seconds)
            timeLeft--
        }

        // If time runs out and no answer selected
        if (selected == null && isActive) {
            isCorrect = false
            history.add(-1)
            showDialog = true
        }
    }

    // Main screen container
    Box(modifier = Modifier.fillMaxSize()) {

        // Background image
        Image(
            painter = painterResource(R.drawable.big_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Dark overlay for better readability
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.35f))
        )

        // Main content column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // Top control buttons (Home / Restart)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = {
                    isActive = false
                    onQuit()
                }) { Text("Home") }

                Button(onClick = {
                    isActive = false
                    onRestart()
                }) { Text("Restart") }
            }

            // Score + Timer display card
            GameCard {

                Text("Question ${index + 1}/${questions.size}")
                Spacer(modifier = Modifier.height(6.dp))

                Text("Score: $score")
                Text("Coins: $coins")

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Time Left: $timeLeft s",
                    color = if (timeLeft <= 5) Color.Red
                    else MaterialTheme.colorScheme.primary
                )
            }

            // Question display area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            ) {

                // Question background image
                Image(
                    painter = painterResource(R.drawable.question_bg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Question text centered
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = question.question,
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(3f, 3f),
                                blurRadius = 8f
                            )
                        ),
                        modifier = Modifier.padding(40.dp)
                    )
                }
            }

            // Answer options list
            question.options.forEachIndexed { i, option ->

                // Dynamic button color based on selection state
                val color = when {
                    selected == null -> MaterialTheme.colorScheme.primary
                    i == question.answer -> Color(0xFF4CAF50) // correct answer
                    i == selected -> Color.Red               // wrong answer
                    else -> Color.Gray
                }

                Button(
                    onClick = {

                        // Prevent multiple selections
                        if (selected != null) return@Button

                        selected = i
                        history.add(i)

                        // Check correctness
                        isCorrect = i == question.answer

                        if (isCorrect) {
                            score += 10
                            coins += 100
                        }

                        showDialog = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = color)
                ) {
                    Text(option)
                }
            }
        }

        // Result dialog (correct / wrong / timeout)
        if (showDialog) {

            AlertDialog(
                onDismissRequest = {},

                title = {
                    Text(
                        when {
                            selected == null -> "Time Up!"
                            isCorrect -> "Correct!"
                            else -> "Wrong!"
                        }
                    )
                },

                text = {
                    Text(if (selected == null) "Time is over" else "Next question")
                },

                confirmButton = {
                    Button(onClick = {

                        showDialog = false

                        if (index == questions.lastIndex) {
                            showSubmitDialog = true
                        } else {
                            selected = null
                            index++
                        }
                    }) {
                        Text("Next")
                    }
                }
            )
        }

        // Final submit dialog
        if (showSubmitDialog) {

            AlertDialog(
                onDismissRequest = {},

                title = { Text("Submit Quiz?") },

                text = { Text("Finish game and submit score?") },

                confirmButton = {
                    Button(onClick = {
                        showSubmitDialog = false
                        onFinish(score, coins, history.toList())
                    }) {
                        Text("Submit")
                    }
                },

                dismissButton = {
                    Button(onClick = {
                        showSubmitDialog = false
                        onQuit()
                    }) {
                        Text("Give Up")
                    }
                }
            )
        }
    }
}