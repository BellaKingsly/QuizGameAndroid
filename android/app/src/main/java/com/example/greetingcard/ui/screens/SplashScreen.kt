/*
 Date: 25/06/2026
 Name: Bella
 File Path: ui/screens/SplashScreen
 Function: Splash screen that shows app title and loading indicator,
           then automatically navigates to the next screen after a delay.
*/

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
    onFinish: () -> Unit // Callback triggered when splash screen ends
) {

    // Automatically navigate after a fixed delay
    LaunchedEffect(Unit) {

        // Wait for 2.5 seconds before navigating
        delay(2.5.seconds)

        // Trigger navigation to next screen
        onFinish()
    }

    // Root container
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Background image (full screen)
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Foreground UI content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,       // Center vertically
            horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
        ) {

            // App title text
            Text(
                "Cyber Quiz Hero",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Loading indicator
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}