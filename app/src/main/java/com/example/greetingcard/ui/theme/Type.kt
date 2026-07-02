/*
 Date: 02/07/2026
 Name: Bella
 File Path: ui/theme/Type.kt
 Function: Defines the typography styles used across the application UI.
*/

package com.example.greetingcard.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles used in the app
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Default app font
        fontWeight = FontWeight.Normal,  // Normal text weight
        fontSize = 16.sp,                // Main text size
        lineHeight = 24.sp,              // Line spacing
        letterSpacing = 0.5.sp           // Space between letters
    )

    /* Other text styles (optional customization)
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)