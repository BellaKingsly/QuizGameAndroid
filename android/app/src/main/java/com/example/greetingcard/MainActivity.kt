/*
 Date: 02/07/2026
 Name: Bella
 File Path: MainActivity
 Function: Entry point of the Android application. Sets up the UI theme
           and launches the main Compose application (GameApp).
*/

package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.greetingcard.ui.GameApp
import com.example.greetingcard.ui.theme.GameTheme

// Main entry point of the app
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the Compose UI content
        setContent {

            // Apply app theme (colors, typography, styling)
            GameTheme {

                // Launch main application screen
                GameApp()
            }
        }
    }
}