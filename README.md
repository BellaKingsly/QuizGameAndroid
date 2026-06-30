# Cyber Quiz Arena

Cyber Quiz Arena is an Android quiz application built with Jetpack Compose.  
It is designed as a simple game-style learning app focused on **cyber security** and **software development** topics.

The app includes a timed quiz system, score tracking, and a coin reward mechanism to simulate game progression.

---

com.example.greetingcard
│
├── backend
│   ├── QuizQuestion.kt
│   ├── QuizRepository.kt
│
├── ui
│   ├── GameApp.kt
│   │
│   ├── screens
│   │     ├── SplashScreen.kt
│   │     ├── HomeScreen.kt
│   │     ├── QuizScreen.kt
│   │     ├── ResultScreen.kt
│   │     ├── ReviewScreen.kt
│   │
│   ├── components
│         ├── GameButton.kt
│         ├── GameCard.kt
│
├── ui.theme
│   ├── GameTheme.kt
│   ├── Color.kt
│   ├── Type.kt

---
## Project Overview

This project is a single-player quiz game where users answer multiple-choice questions under a time limit.  
Each correct answer increases the player’s score and coin balance.

The application is structured using a screen-based navigation system controlled inside `GameApp.kt`.

---

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- Coroutines (for countdown timer)
- Basic state management using Compose `remember`

---

## Game Flow

The application follows this flow:

Splash Screen → Home Screen → Quiz Screen → Result Screen → Review Screen

---

## Screens Description

### 1. Splash Screen

**File:** `SplashScreen.kt`

Purpose:
- Displays a loading screen when the app starts
- Shows the game title and logo image
- Waits for a few seconds before entering the Home Screen

Functionality:
- Automatically navigates to Home Screen after delay
- Used as an introduction screen for the game

---

### 2. Home Screen

**File:** `HomeScreen.kt`

Purpose:
- Main entry screen of the game

Functionality:
- Displays last game score
- Displays total coins earned
- Provides button to start a new quiz
- Provides button to view answer history (Review Screen)

User actions:
- Start Quiz → enters Quiz Screen
- View History → enters Review Screen

---

### 3. Quiz Screen

**File:** `QuizScreen.kt`

Purpose:
- Main gameplay screen

Functionality:
- Displays quiz questions one by one
- Each question has 4 multiple-choice options
- Includes a 20-second countdown timer per question
- Tracks score and coins in real time
- Stores user answers for later review

Game rules:
- Correct answer: +10 score, +100 coins
- Wrong answer: no reward
- Timeout: auto skip to next question

End condition:
- After 10 questions, game automatically navigates to Result Screen

---

### 4. Result Screen

**File:** `ResultScreen.kt`

Purpose:
- Displays final game results after completing all questions

Functionality:
- Shows final score
- Shows total coins earned
- Provides option to restart the quiz
- Provides option to return to Home Screen

User actions:
- Play Again → restart quiz
- Home → return to main screen

---

### 5. Review Screen

**File:** `ReviewScreen.kt`

Purpose:
- Allows users to review all answered questions

Functionality:
- Displays all quiz questions
- Shows user selected answers
- Shows correct answers for comparison

User actions:
- Back button returns to Home Screen

---

## Backend Logic

### Quiz Repository

**File:** `QuizRepository.kt`

Purpose:
- Stores all quiz questions used in the game

Contains:
- Question text
- Multiple choice options
- Correct answer index
- Explanation for each answer

---

### Quiz Question Model

**File:** `QuizQuestion.kt`

Purpose:
- Defines the data structure for quiz questions

Fields:
- id
- question
- options
- answer
- explanation

---

## Game Rules

- Each game contains 10 questions
- Each question has a 20-second time limit
- Correct answer gives:
  - +10 score
  - +100 coins
- Wrong answer gives no reward
- If time runs out, question is skipped automatically

---

## UI Design

- Simple game-style layout using Material 3
- Warm theme colors (orange and green)
- Clear feedback for correct and wrong answers
- Focus on readability and interaction speed

---

## Future Improvements

- Add difficulty levels (Easy / Medium / Hard)
- Add sound effects for correct and wrong answers
- Add leaderboard system
- Connect backend API for dynamic questions
- Add animations for transitions between screens
- Add user profile system

---

## How to Run

1. Open project in Android Studio
2. Sync Gradle files
3. Run on emulator or physical Android device
4. App starts from Splash Screen automatically
