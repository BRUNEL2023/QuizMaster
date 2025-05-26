package com.example.quizmaster.ui.theme

import android.content.Context // ✅ CORRECT !
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val prefs = getSharedPreferences("QUIZ_APP", Context.MODE_PRIVATE) // ✅ C’est ça qu’il faut
        val totalScore = prefs.getInt("totalScore", 0)

        val scoreText = findViewById<TextView>(R.id.scoreTextView)
        scoreText.text = "Score total : $totalScore"
    }
}
