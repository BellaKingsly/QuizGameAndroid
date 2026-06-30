package com.example.greetingcard.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.Color

// Game color theme
private val GameColors = lightColorScheme(
    primary = GameOrange,
    secondary = GameGreen,
    background = GameBackground,
    surface = GameWhite,
    error = GameRed
)

@Composable
fun GameTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = GameColors,
        typography = Typography,
        content = content
    )
}