package com.example.greetingcard.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.greetingcard.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreen(
    onFinish: () -> Unit
) {

    // Auto navigate after 2.5 seconds
    LaunchedEffect(Unit) {
//        delay(2500)
        delay(2.5.seconds)
        onFinish()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Background image (FULL SCREEN)
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Foreground content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Cyber Quiz Hero",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(20.dp))

            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}