package com.example.greetingcard.ui

import androidx.compose.runtime.*
import com.example.greetingcard.backend.QuizRepository
import com.example.greetingcard.ui.screens.*

@Composable
fun GameApp() {

    // Current page state
    var screen by remember { mutableStateOf("splash") }

    // global game results
    var score by remember { mutableIntStateOf(0) }
    var coins by remember { mutableIntStateOf(0) }

    // answer history (for review screen)
    var history by remember {
        mutableStateOf<List<Int>>(emptyList())
    }
    // load questions once
    val questions = remember {
        QuizRepository.getQuestions()
    }
    // reset all game data
    fun resetGame() {
        score = 0
        coins = 0
        history = emptyList()
    }
    // Add trigger
    var restartKey by remember { mutableIntStateOf(0) }

    when (screen) {
        // splash screen
        "splash" -> SplashScreen {
            screen = "home"
        }
        // home screen
        "home" -> HomeScreen(
            finalScore = score,
            coins = coins,
            onStartQuiz = {
                resetGame()
                screen = "quiz"
            }
        )
        // quiz game screen
//        "quiz" -> BattleScreen(
//            questions = questions,
//
//            onFinish = { s, c, h ->
//                score = s
//                coins = c
//                history = h
//                screen = "result"
//            },
//
//            onQuit = {
//                screen = "home"
//            },
//            // restart FIX (FULL RESET)
//            onRestart = {
//                resetGame()       // clear score + coins + history
//                screen = "quiz"
//            }
//        )
        "quiz" -> key(restartKey) {
            BattleScreen(
                questions = questions,

                onFinish = { s, c, h ->
                    score = s
                    coins = c
                    history = h
                    screen = "result"
                },

                onQuit = {
                    screen = "home"
                },

                onRestart = {
                    score = 0
                    coins = 0
                    history = emptyList()
                    restartKey++   // reload screen
                }
            )
        }
        // result screen
        "result" -> ResultScreen(
            finalScore = score,
            coins = coins,

            onRestart = {
                screen = "quiz"
            },

            onReview = {
                screen = "review"
            },

            onHome = {
                screen = "home"
            }
        )
        // ⭐ THIS IS THE PART YOU MISSED
        "history" -> HistoryScreen(
            questions = questions,
            answers = history,

            onBack = {
                screen = "home"
            },

            onRestart = {
                resetGame()
                screen = "quiz"
            }
        )
        // review screen
        "review" -> ReviewScreen(
            questions = questions,
            history = history,

            onBack = {
                screen = "home"
            }
        )
    }
}