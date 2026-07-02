/*
 Date: Date: 24/06/2026
 Name: Bella
 File Path: ui/components/GameCard
 Function: A reusable card component used to wrap content with consistent padding,
           background color, and elevation styling in the game UI.
*/

package com.example.greetingcard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Reusable card component for consistent UI layout
// Used to display content inside a styled Material card container
@Composable
fun GameCard(
    modifier: Modifier = Modifier, // Allow external customization of layout
    content: @Composable ColumnScope.() -> Unit // Content inside the card
) {

    // Material 3 Card container
    Card(
        modifier = modifier.fillMaxWidth(), // Card takes full width by default

        // Define card background color
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Set white background for clean UI
        ),

        // Set shadow/elevation effect
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        // Inner content container with padding
        Column(
            modifier = Modifier.padding(16.dp), // Inner spacing for content
            content = content // Render user-provided composable content
        )
    }
}
