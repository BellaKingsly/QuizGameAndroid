/*
 Date: Date: 02/07/2026
 Name: Bella
 File Path: ui/GameApp
 Function: Main navigation controller of the app. Manages screens,
           game state, API data loading, and overall quiz flow.
*/

package com.example.greetingcard.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.greetingcard.backend.ApiClient
import com.example.greetingcard.backend.QuizQuestionDto
import com.example.greetingcard.ui.screens.*

@Composable
fun GameApp() {

    // Current screen state (controls navigation)
    var screen by remember { mutableStateOf("splash") }

    // Last completed game results (used on home screen)
    var lastScore by remember { mutableIntStateOf(0) }
    var lastCoins by remember { mutableIntStateOf(0) }

    // Current active game results
    var score by remember { mutableIntStateOf(0) }
    var coins by remember { mutableIntStateOf(0) }

    // User answer history (-1 = timeout or no answer)
    var history by remember {
        mutableStateOf<List<Int>>(emptyList())
    }

    // Quiz questions loaded from backend API
    var questions by remember {
        mutableStateOf<List<QuizQuestionDto>>(emptyList())
    }

    // Loading state for API request
    var loading by remember { mutableStateOf(true) }

    // Fetch questions from Spring Boot backend
    LaunchedEffect(Unit) {
        try {
            questions = ApiClient.api.getQuestions()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            loading = false
        }
    }

    // Reset game state (score, coins, history)
    fun resetGame() {
        score = 0
        coins = 0
        history = emptyList()
    }

    // Used to force restart BattleScreen recomposition
    var restartKey by remember { mutableIntStateOf(0) }

    // Screen navigation logic
    when (screen) {

        // Splash screen (app startup)
        "splash" -> SplashScreen {
            screen = "home"
        }

        // Home screen (main menu)
        "home" -> HomeScreen(
            finalScore = lastScore,
            coins = lastCoins,
            onStartQuiz = {
                screen = "quiz"
            }
        )

        // Quiz gameplay screen
        "quiz" -> {

            // Show loading spinner while fetching data
            if (loading) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }

            } else {

                // Force recompose BattleScreen when restarting
                key(restartKey) {

                    BattleScreen(
                        questions = questions,

                        // Called when quiz ends normally
                        onFinish = { s, c, h ->

                            lastScore = s
                            lastCoins = c

                            score = s
                            coins = c
                            history = h

                            screen = "result"
                        },

                        // Quit quiz and return home
                        onQuit = {
                            screen = "home"
                        },

                        // Restart quiz (reset state and force reload screen)
                        onRestart = {
                            resetGame()
                            restartKey++
                        }
                    )
                }
            }
        }

        // Result screen after finishing quiz
        "result" -> ResultScreen(
            finalScore = score,
            coins = coins,

            onRestart = {
                resetGame()
                restartKey++
                screen = "quiz"
            },

            onReview = {
                screen = "review"
            },

            onHome = {
                screen = "home"
            }
        )

        // History screen (not actively used in flow but available)
        "history" -> HistoryScreen(
            questions = questions,
            answers = history,

            onBack = {
                screen = "home"
            },

            onRestart = {
                resetGame()
                restartKey++
                screen = "quiz"
            }
        )

        // Review screen (detailed answer explanation)
        "review" -> ReviewScreen(
            questions = questions,
            history = history,

            onBack = {
                screen = "home"
            }
        )
    }
}