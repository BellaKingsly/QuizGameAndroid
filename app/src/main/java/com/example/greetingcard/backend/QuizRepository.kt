package com.example.greetingcard.backend

object QuizRepository {

    private val questions = listOf(

        QuizQuestion(
            1,
            "What does HTTP stand for?",
            listOf(
                "HyperText Transfer Protocol",
                "Home Transfer Text Protocol",
                "High Text Transfer Process",
                "Hyper Tool Transfer Protocol"
            ),
            0,
            "HTTP is the main protocol used on the web."
        ),

        QuizQuestion(
            2,
            "Who created Kotlin?",
            listOf(
                "Google",
                "JetBrains",
                "Apple",
                "Microsoft"
            ),
            1,
            "Kotlin was developed by JetBrains."
        ),

        QuizQuestion(
            3,
            "Which attack steals passwords using fake websites?",
            listOf(
                "Phishing",
                "DoS",
                "Spoofing",
                "Scanning"
            ),
            0,
            "Phishing tricks users into entering credentials."
        ),

        QuizQuestion(
            4,
            "What keyword creates a class in Kotlin?",
            listOf(
                "class",
                "fun",
                "var",
                "new"
            ),
            0,
            "The class keyword defines a class."
        ),

        QuizQuestion(
            5,
            "Which tool scans network ports?",
            listOf(
                "Nmap",
                "Git",
                "Docker",
                "Gradle"
            ),
            0,
            "Nmap scans networks and ports."
        ),

        QuizQuestion(
            6,
            "What symbol starts a comment in Kotlin?",
            listOf("//", "##", "**", "@@"),
            0,
            "Single line comments use //"
        ),

        QuizQuestion(
            7,
            "What is SQL Injection?",
            listOf(
                "Database attack",
                "Password manager",
                "Encryption",
                "Firewall"
            ),
            0,
            "SQL Injection targets databases."
        ),

        QuizQuestion(
            8,
            "Which company develops Android?",
            listOf(
                "Google",
                "Apple",
                "Microsoft",
                "Meta"
            ),
            0,
            "Android is maintained by Google."
        ),

        QuizQuestion(
            9,
            "What does IDE mean?",
            listOf(
                "Integrated Development Environment",
                "Internet Development Engine",
                "Internal Debug Editor",
                "Input Design Extension"
            ),
            0,
            "IDE is software used for coding."
        ),

        QuizQuestion(
            10,
            "Which protocol is secure?",
            listOf(
                "HTTPS",
                "HTTP",
                "FTP",
                "Telnet"
            ),
            0,
            "HTTPS encrypts communication."
        )
    )

    fun getQuestions() = questions.shuffled()
}