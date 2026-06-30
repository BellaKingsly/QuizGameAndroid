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

        setContent {
            GameTheme {
                GameApp()
            }
        }
    }
}