# Quiz Game Android App

Quiz Game Android App is an Android quiz application built with Jetpack Compose.

It is designed as a simple game-style learning application focused on **cyber security** and **software development** topics.

The project consists of three major components:

- Android application
- Wear OS companion application
- Spring Boot backend service

The app includes a timed quiz system, score tracking, a coin reward mechanism, and cross-device synchronization between the mobile phone and smartwatch.

---

# Project Structure

- Android Studio
- Kotlin
- Java Spring Boot
- MySQL
- DBeaver

```text
QuizGameAndroid/
│
├── android/   (Android Frontend - Kotlin)
│   └── app/
│       └── src/
│           └── main/
│               └── java/
│                   └── com.example.greetingcard/
│                       │
│                       ├── backend/
│                       │   ├── ApiClient.kt
│                       │   ├── ApiConfig.kt
│                       │   ├── ApiService.kt
│                       │   └── QuizQuestionDto.kt
│                       │
│                       ├── communication/
│                       │   ├── WearDataClient.kt
│                       │   ├── WearKeys.kt
│                       │   └── WearPaths.kt
│                       │
│                       ├── data/
│                       │   └── model/
│                       │       └── StudyReminder.kt
│                       │
│                       ├── ui/
│                       │   ├── GameApp.kt
│                       │   │
│                       │   ├── components/
│                       │   │   ├── GameButton.kt
│                       │   │   └── GameCard.kt
│                       │   │
│                       │   ├── screens/
│                       │   │   ├── BattleScreen.kt
│                       │   │   ├── HistoryScreen.kt
│                       │   │   ├── HomeScreen.kt
│                       │   │   ├── ResultScreen.kt
│                       │   │   ├── ReviewScreen.kt
│                       │   │   └── SplashScreen.kt
│                       │   │
│                       │   └── theme/
│                       │       ├── Color.kt
│                       │       ├── GameTheme.kt
│                       │       └── Type.kt
│                       │
│                       └── MainActivity.kt
│
├── wearOS/   (Wear OS Frontend - Kotlin)
│   └── app/
│       └── src/
│           └── main/
│               └── java/
│                   └── com.example.wearos/
│                       │
│                       ├── data/
│                       │   ├── model/
│                       │   │   ├── QuizScore.kt
│                       │   │   ├── StudyReminder.kt
│                       │   │   └── StudyTask.kt
│                       │   │
│                       │   └── repository/
│                       │       ├── QuizResultRepository.kt
│                       │       └── StudyRepository.kt
│                       │
│                       ├── presentation/
│                       │   ├── communication/
│                       │   │   ├── WearDataClient.kt
│                       │   │   ├── WearDataListenerService.kt
│                       │   │   ├── WearKeys.kt
│                       │   │   └── WearPaths.kt
│                       │   │
│                       │   ├── component/
│                       │   │   ├── ScoreCard.kt
│                       │   │   └── StudyCard.kt
│                       │   │
│                       │   ├── notification/
│                       │   │   └── ReminderNotification.kt
│                       │   │
│                       │   ├── screen/
│                       │   │   ├── CreateReminderScreen.kt
│                       │   │   ├── HomeScreen.kt
│                       │   │   └── ScoreScreen.kt
│                       │   │
│                       │   ├── theme/
│                       │   │   ├── Color.kt
│                       │   │   ├── Theme.kt
│                       │   │   └── Type.kt
│                       │   │
│                       │   └── viewmodel/
│                       │       ├── ReminderViewModel.kt
│                       │       └── StudyViewModel.kt
│                       │
│                       └── MainActivity.kt
│
├── backend/   (Spring Boot Backend - Java)
│   └── quiz-backend/
│       │
│       ├── src/
│       │   └── main/
│       │       ├── java/
│       │       │   └── com.example.quiz_backend/
│       │       │       │
│       │       │       ├── config/
│       │       │       │   └── CorsConfig.java
│       │       │       │
│       │       │       ├── controller/
│       │       │       │   └── QuizController.java
│       │       │       │
│       │       │       ├── dto/
│       │       │       │   └── QuizQuestionDTO.java
│       │       │       │
│       │       │       ├── entity/
│       │       │       │   └── QuizQuestionEntity.java
│       │       │       │
│       │       │       ├── repository/
│       │       │       │   └── QuizRepository.java
│       │       │       │
│       │       │       ├── service/
│       │       │       │   └── QuizService.java
│       │       │       │
│       │       │       └── QuizBackendApplication.java
│       │       │
│       │       └── resources/
│       │           └── application.properties
│       │
│       ├── test/
│       ├── HELP.md
│       ├── mvnw
│       ├── mvnw.cmd
│       └── pom.xml
│
└── README.md
```

---

# Project Overview

This project is a single-player quiz game where users answer multiple-choice questions under a time limit.

Each correct answer increases the player's score and coin balance.

The application uses a screen-based navigation system managed by `GameApp.kt`.

The project also integrates a Wear OS companion application, allowing users to synchronize quiz results and study reminders between the phone and smartwatch.

---

# Tech Stack

## Android

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- Coroutines
- Compose State Management

## Wear OS

- Kotlin
- Wear Compose
- ViewModel
- StateFlow
- Data Layer API
- Notification Manager

## Backend

- Java Spring Boot
- Spring Data JPA
- REST API
- Maven

## Database

- MySQL
- DBeaver

---

# Backend Architecture

The backend is implemented using **Java Spring Boot**.

It is responsible for:

- Fetching quiz questions
- Managing DTO objects
- Processing frontend requests
- Providing REST APIs
- Connecting to the database

The backend architecture separates the presentation layer, service layer, and persistence layer.

```text
Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
MySQL Database
```

---

# Database

The application uses **MySQL** as the primary database.

The database stores:

- Quiz questions
- Answer options
- Correct answers
- Explanations

DBeaver is used to:

- View database tables
- Execute SQL queries
- Test APIs
- Debug backend data

---

# System Overview

Quiz Game Android App follows a client-server architecture.

```text
Frontend (Android)
        ↓
Spring Boot REST API
        ↓
MySQL Database
```

The Wear OS application communicates with the Android application through Google's Data Layer API.

---

# Business Workflow

The Quiz Game Android App integrates Android, Wear OS, Spring Boot, and MySQL into a complete workflow.

---

## 1. Application Startup

- The user opens the Android application.
- The application starts from `SplashScreen`.
- Navigation is controlled by `GameApp.kt`.
- The user enters the home page.

Workflow:

```text
SplashScreen
      ↓
HomeScreen
      ↓
BattleScreen
```

---

## 2. Quiz Question Retrieval

The Android application retrieves quiz questions from the backend server.

Workflow:

```text
Android App
      ↓
ApiClient
      ↓
ApiService
      ↓
QuizController
      ↓
QuizService
      ↓
QuizRepository
      ↓
MySQL Database
```

Process:

1. Android sends an HTTP request.
2. Spring Boot receives the request.
3. The repository queries MySQL.
4. Quiz data is converted into DTO objects.
5. JSON data is returned to Android.

---

## 3. Quiz Gameplay

The user enters the quiz page.

Features:

- Multiple-choice questions
- Countdown timer
- Real-time scoring
- Coin rewards

For each correct answer:

- Score increases.
- Coins increase.

After all questions are completed:

- The final score is calculated.
- Accuracy is calculated.
- Results are saved in memory.

---

## 4. Result Display

After finishing the quiz:

The user can:

- View final score.
- Review answers.
- Check quiz history.
- Return to the home page.

Workflow:

```text
BattleScreen
      ↓
ResultScreen
      ↓
ReviewScreen
      ↓
HistoryScreen
```

---

## 5. Android–Wear OS Synchronization

After the quiz ends, the Android application synchronizes data with Wear OS.

Synchronized data:

- Score
- Accuracy
- Coins

Workflow:

```text
Android Phone
      ↓
WearDataClient
      ↓
Google Data Layer API
      ↓
WearDataListenerService
      ↓
QuizResultRepository
      ↓
ScoreScreen
```

Communication paths:

```text
/quiz_result
/study_reminder
/study_completed
```

---

## 6. Study Reminder Workflow

Users can create study reminders on the Android device.

Workflow:

```text
Android App
      ↓
Create Reminder
      ↓
WearDataClient
      ↓
Wear OS
      ↓
ReminderNotification
      ↓
Study Completion
      ↓
Android App
```

Process:

1. The user creates a reminder.
2. Reminder data is sent to Wear OS.
3. Wear OS stores the reminder.
4. A notification is displayed.
5. The user marks the task as completed.
6. Completion status is synchronized back to Android.

---

## 7. Overall System Architecture

```text
                  ┌──────────────────┐
                  │   Android App    │
                  │ Jetpack Compose  │
                  └────────┬─────────┘
                           │
                     HTTP / REST
                           │
                           ▼
                ┌─────────────────────┐
                │ Spring Boot Backend │
                └────────┬────────────┘
                         │
                         ▼
                ┌─────────────────────┐
                │   MySQL Database    │
                └─────────────────────┘

                         ▲
                         │

                 Google Data Layer

                         │
                         ▼

                  ┌──────────────────┐
                  │    Wear OS App   │
                  └──────────────────┘
```

---

# Application Features

## Android Application

- Timed quiz mode
- Score system
- Coin reward system
- Quiz history
- Answer review
- Study reminder creation
- Wear OS synchronization

---

## Wear OS Application

- Display quiz results
- Display study reminders
- Local notifications
- Task completion
- Synchronization with Android

---

## Backend Service

- RESTful API
- Quiz management
- DTO processing
- Database integration

---

# API Endpoint

```http
GET /api/quiz/questions
```

Example:

```json
[
  {
    "id": 1,
    "question": "What is TCP?",
    "options": [
      "Protocol A",
      "Protocol B",
      "Protocol C",
      "Protocol D"
    ],
    "answer": "Protocol A",
    "explanation": "TCP is a transport protocol."
  }
]
```

---

# How to Run

1. Open the project in Android Studio.
2. Sync Gradle files.
3. Configure MySQL.
4. Start the Spring Boot backend.
5. Run the Android emulator or a physical device.
6. Connect a Wear OS emulator or smartwatch.
7. Launch the Android application.

---

# Author

**Name:** Bella

**Email:** bellakingsly.c@gmail.com

**University:** Keep secret for now

**Programme:** Keep secret for now
