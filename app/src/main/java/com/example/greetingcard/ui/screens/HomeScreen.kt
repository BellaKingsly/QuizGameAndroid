/*
 Date: 30/06/2026
 Name: Bella
 File Path: ui/screens/HomeScreen
 Function: Main entry screen of the app. Displays title, last score,
           coins, and provides a button to start the quiz.
*/

package com.example.greetingcard.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.greetingcard.R
import com.example.greetingcard.ui.components.GameButton

@Composable
fun HomeScreen(
    finalScore: Int,      // Last game score shown on home screen
    coins: Int,           // Total coins earned in previous game
    onStartQuiz: () -> Unit // Start quiz callback
) {

    // Root container
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Background image for home screen
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Main UI layer
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,       // Center vertically
            horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
        ) {

            // App title
            Text(
                "Cyber Security & Coding",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Subtitle
            Text(
                "Quiz Battle Mode",
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Score summary card
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Last Score: $finalScore")
                    Text("Coins: 💰 $coins")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Start quiz button (custom reusable component)
            GameButton(
                text = "Start Quiz",
                onClick = onStartQuiz,
                backgroundRes = R.drawable.button_bg
            )
        }
    }
}