/*
 Date: Date: 23/06/2026
 Name: Bella
 File Path: ui/components/GameButton
 Function: A reusable custom UI button with image background and centered text,
           used in the game UI for consistent button styling.
*/

package com.example.greetingcard.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// A custom game-style button component
// Displays a background image with centered text and handles click events
@Composable
fun GameButton(
    text: String,              // Button text displayed in the center
    onClick: () -> Unit,       // Callback function when the button is clicked
    backgroundRes: Int         // Image resource used as button background
) {

    // Container for the button layout
    Box(
        modifier = Modifier
            .fillMaxWidth()     // Button takes full width
            .height(65.dp)      // Fixed height for consistent UI style
            .clickable { onClick() } // Handle click interaction
    ) {

        // Background image for the button
        Image(
            painter = painterResource(backgroundRes),
            contentDescription = null, // No accessibility text needed for background
            modifier = Modifier.fillMaxSize(), // Image fills entire button area
            contentScale = ContentScale.Crop   // Crop image to fit properly
        )

        // Overlay container to center the text
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            // Button text styling
            Text(
                text = text,
                fontSize = 22.sp, // Large readable font size
                fontWeight = FontWeight.Bold, // Bold for emphasis
                color = MaterialTheme.colorScheme.onPrimary // Theme-based text color
            )
        }
    }
}