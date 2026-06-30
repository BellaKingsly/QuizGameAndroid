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
    finalScore: Int,
    coins: Int,
    onStartQuiz: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Background image
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // UI layer
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Cyber Security & Coding",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Quiz Battle Mode",
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(30.dp))

            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Last Score: $finalScore")
                    Text("Coins: 💰 $coins")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            GameButton(
                text = "Start Quiz",
                onClick = onStartQuiz,
                backgroundRes = R.drawable.button_bg
            )
        }
    }
}