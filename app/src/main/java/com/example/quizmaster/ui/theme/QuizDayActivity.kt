package com.example.quizmaster.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class QuizDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_day)

        val chapitre = intent.getStringExtra("chapitre") ?: "Chapitre inconnu"
        val matiere = intent.getStringExtra("matiere") ?: "Matière inconnue"

        val quizTitle = findViewById<TextView>(R.id.titleQuizDay)
        quizTitle.text = "Quiz – $matiere : $chapitre"

        val recap = findViewById<TextView>(R.id.recap)
        recap.text = "Prépare-toi à tester tes connaissances sur \"$chapitre\"."

        val startBtn = findViewById<Button>(R.id.startQuizBtn)
        startBtn.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("matiere", matiere)
            intent.putExtra("chapitre", chapitre)
            startActivity(intent)
        }
    }
}
