/*
Date: 02/07/2026
Name: Bella
File Path: ui/theme/Theme.kt
Function: Defines the global Material theme using a custom color scheme for the app UI.
*/

package com.example.greetingcard.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

// Define app color theme
private val GameColors = lightColorScheme(
    primary = GameOrange,      // Main buttons and actions
    secondary = GameGreen,     // Success and correct answers
    background = GameBackground, // App background
    surface = GameWhite,      // Cards and UI surfaces
    error = GameRed           // Wrong answers / errors
)

// Apply global theme to the whole app
@Composable
fun GameTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = GameColors, // Apply color scheme
        typography = Typography,   // Apply text styles
        content = content          // App UI content
    )
}