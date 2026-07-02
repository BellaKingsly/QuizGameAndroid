/*
 Date: Date: 27/06/2026
 Name: Bella
 File Path: ui/screens/ResultScreen
 Function: Displays final quiz result including score, coins earned,
           performance message, and navigation options (restart, review, home).
*/

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
    finalScore: Int,     // Final score achieved by the user
    coins: Int,          // Coins earned in the game

    onRestart: () -> Unit, // Restart quiz game
    onReview: () -> Unit,   // Navigate to answer review screen
    onHome: () -> Unit      // Return to home screen
) {

    // Dynamic result message based on final score
    val message = when {
        finalScore < 50 -> "Mission Failed! Keep practicing and try again."
        finalScore < 70 -> "Great Job! Keep Going!"
        else -> "Amazing! You Are a Cyber Hero!"
    }

    // Root container
    Box(modifier = Modifier.fillMaxSize()) {

        // Background image for result screen
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Main content layout
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

            // Result information card
            GameCard {

                // Final score display
                Text(
                    text = "Final Score: $finalScore",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF4CAF50) // green highlight for score
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Success label
                Text(
                    text = "Congratulations!",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Coins reward display
                Text(
                    text = "You earned 💰 $coins Coins",
                    color = Color(0xFFFF8A00) // orange reward color
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Performance feedback message
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Restart game button
            Button(
                onClick = onRestart,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Play Again")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Review answers button
            Button(
                onClick = onReview,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Review Answers")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Return to home button (highlighted green style)
            Button(
                onClick = onHome,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50),
                    contentColor = Color.White
                )
            ) {
                Text("Home")
            }
        }
    }
}