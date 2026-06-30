package com.example.greetingcard.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.greetingcard.R
import com.example.greetingcard.ui.components.GameCard

@Composable
fun ResultScreen(
    finalScore: Int,
    coins: Int,

    onRestart: () -> Unit,
    onReview: () -> Unit,
    onHome: () -> Unit
) {

    // Game result message based on score
    val message = when {
        finalScore < 50 -> "Mission Failed! Keep practicing and try again."
        finalScore < 70 -> "Great Job! Keep Going!"
        else -> "Amazing! You Are a Cyber Hero!"
    }

    Box(modifier = Modifier.fillMaxSize()) {

        // Background image
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Screen title
            Text(
                text = "MISSION COMPLETE",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Result card UI
            GameCard {

                // Final score (important result)
                Text(
                    text = "Final Score: $finalScore",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF4CAF50) // green highlight
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Success message
                Text(
                    text = "Congratulations!",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Coins earned
                Text(
                    text = "You earned 💰 $coins Coins",
                    color = Color(0xFFFF8A00) // orange reward color
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Score feedback message
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Restart button
            Button(
                onClick = onRestart,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Play Again")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Review button
            Button(
                onClick = onReview,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Review Answers")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Home button (GREEN BUTTON)
            Button(
                onClick = onHome,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50), // green background
                    contentColor = Color.White          // white text
                )
            ) {
                Text("Home")
            }
        }
    }
}