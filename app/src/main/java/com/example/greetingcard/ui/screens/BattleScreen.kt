package com.example.greetingcard.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.greetingcard.R
import com.example.greetingcard.backend.QuizQuestion
import com.example.greetingcard.ui.components.GameCard
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.geometry.Offset
@Composable
fun BattleScreen(
    questions: List<QuizQuestion>,
    onFinish: (score: Int, coins: Int, history: List<Int>) -> Unit,
    onQuit: () -> Unit,
    onRestart: () -> Unit
) {

    // game state
    var index by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }
    var coins by remember { mutableIntStateOf(0) }
    // selected answer
    var selected by remember { mutableStateOf<Int?>(null) }

    // use mutable list for performance
    // history list
    val history = remember { mutableStateListOf<Int>() }
    // timer state
    var timeLeft by remember { mutableIntStateOf(20) }
    var showDialog by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }
    // current question
    val question = questions.getOrNull(index)

    // end game
    if (question == null) {
        onFinish(score, coins, history.toList())
        return
    }

    // timer per question
    LaunchedEffect(index) {
        // reset timer every question
        timeLeft = 20
        selected = null
        showDialog = false
        // countdown loop
        while (timeLeft > 0 && selected == null) {
//            delay(1000)
//            delay(1000L)
            delay(1.seconds)
            timeLeft--
        }

        // timeout case
        if (selected == null) {
            isCorrect = false
            showDialog = true
            history.add(-1) // -1 means no answer
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image (Full Screen)
        Image(
            painter = painterResource(R.drawable.big_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Dark Overlay (make UI readable)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.35f))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // top buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = onQuit,
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
                ) {
                    Text("Home")
                }

                Button(
                    onClick = onRestart,
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
                ) {
                    Text("Restart")
                }
            }

            // game info card
            GameCard {

                // question index
                Text("Question ${index + 1}/${questions.size}")

                Spacer(modifier = Modifier.height(6.dp))

                // score row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.score),
                        contentDescription = "score icon",
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Score: $score")
                }

                Spacer(modifier = Modifier.height(6.dp))

                // coins row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.coin),
                        contentDescription = "coin icon",
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Coins: $coins")
                }

                Spacer(modifier = Modifier.height(6.dp))

                // timer
                Text(
                    text = "Time Left: $timeLeft s",
                    color = if (timeLeft <= 5) Color.Red
                    else MaterialTheme.colorScheme.primary
                )
            }

            // question box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .fillMaxSize()

            ) {

                Image(
                    painter = painterResource(R.drawable.question_bg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                  //background surface

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color.Black.copy(alpha = 0.4f)
//                ) {}

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = question.question,

                        // text style
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,

                        // center text
                        textAlign = TextAlign.Center,

                        // increase line spacing
                        lineHeight = 36.sp,

                        // add shadow for better readability
                        style = MaterialTheme.typography.headlineSmall.copy(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(3f, 3f),
                                blurRadius = 8f
                            )
                        ),

                        modifier = Modifier
                            .fillMaxWidth()
                            // add left and right boundaries
                            .padding(
                                start = 50.dp,
                                end = 50.dp,
                                top = 20.dp,
                                bottom = 20.dp
                            )
                    )
                }
            }

            // answers
            question.options.forEachIndexed { i, option ->

                val color = when {
                    selected == null -> MaterialTheme.colorScheme.primary
                    i == question.answer -> Color(0xFF4CAF50)
                    i == selected -> Color.Red
                    else -> Color.Gray
                }

                Button(
                    onClick = {

                        if (selected != null) return@Button

                        selected = i
                        history.add(i)

                        isCorrect = i == question.answer

                        if (isCorrect) {
                            score += 10
                            coins += 100
                        }

                        showDialog = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = color)
                ) {
                    Text(option)
                }
            }
        }

        // result dialog
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {},
                title = {
                    Text(
                        when {
                            selected == null -> "Time Up!"
                            isCorrect -> "Correct!"
                            else -> "Wrong!"
                        }
                    )
                },
                text = {
                    Text(
                        if (selected == null) "Time is over"
                        else "Next question"
                    )
                },
                confirmButton = {
                    Button(onClick = {
                        showDialog = false
                        selected = null
                        index++
                    }) {
                        Text("Next")
                    }
                }
            )
        }
    }
}