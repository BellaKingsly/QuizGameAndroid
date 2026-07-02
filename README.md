# Cyber Quiz Arena

Cyber Quiz Arena is an Android quiz application built with Jetpack Compose.  
It is designed as a simple game-style learning app focused on **cyber security** and **software development** topics.

The app includes a timed quiz system, score tracking, and a coin reward mechanism to simulate game progression.

---

## Project Structure

```text
com.example.greetingcard
│
├── backend
│   ├── ApiClient.kt
│   ├── ApiConfig.kt
│   ├── ApiService.kt
│   ├── QuizQuestionDto.kt
│
├── ui
│   ├── GameApp.kt
│   │
│   ├── screens
│   │     ├── BattleScreen.kt
│   │     ├── HistoryScreen.kt
│   │     ├── HomeScreen.kt
│   │     ├── ResultScreen.kt
│   │     ├── ReviewScreen.kt
│   │     ├── SplashScreen.kt
│   │
│   ├── components
│         ├── GameButton.kt
│         ├── GameCard.kt
│
├── ui.theme
│   ├── GameTheme.kt
│   ├── Color.kt
│   ├── Type.kt
```

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

## Tech Stack

- Kotlin  
- Jetpack Compose  
- Material 3  
- Coroutines (used for countdown timer)  
- State management using Compose `remember`  
- Java Spring Boot (backend API development)  
- MySQL (database)  
- DBeaver (database management tool)

---

## Backend Architecture

The backend of **Cyber Quiz Arena** is built using **Java Spring Boot**, which provides RESTful APIs for handling quiz-related data and game logic.

It is responsible for:

- Fetching quiz questions from the database  
- Managing Quiz Data Transfer Objects (DTOs)  
- Processing frontend requests during gameplay  
- Providing structured and scalable REST API endpoints  

This design allows clear separation between frontend (Android app) and backend services.

---

## Database

The project uses **MySQL** as the main relational database to store all quiz-related data, including questions, multiple-choice options, correct answers, and explanations.

A database management tool (**DBeaver**) is used to:

- Visualize database structure  
- Execute SQL queries  
- Manage and test data during development  
- Debug and verify backend data consistency  

---

## System Overview

Cyber Quiz Arena follows a **client-server architecture**:

- **Frontend:** Android app built with Jetpack Compose  
- **Backend:** Java Spring Boot REST API  
- **Database:** MySQL managed with DBeaver  

The frontend communicates with the backend via HTTP requests to retrieve quiz data and submit gameplay results.

---

## How to Run

1. Open project in Android Studio
2. Sync Gradle files
3. Run on emulator or physical Android device
4. App starts from Splash Screen automatically
