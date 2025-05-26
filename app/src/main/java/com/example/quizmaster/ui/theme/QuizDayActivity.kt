package com.example.quizmaster.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class QuizDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_day)


        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        val imgSettings = findViewById<ImageView>(R.id.imgSettings)

        val chapitre = intent.getStringExtra("chapitre") ?: "Chapitre inconnu"
        val matiere = intent.getStringExtra("matiere") ?: "Matière inconnue"

        val quizTitle = findViewById<TextView>(R.id.titleQuizDay)
        quizTitle.text = "Quiz – $matiere : $chapitre"

        val recap = findViewById<TextView>(R.id.recap)
        recap.text = "Prépare-toi à tester tes connaissances sur \"$chapitre\"."

        imgSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        imgProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        val startBtn = findViewById<Button>(R.id.startQuizBtn)
        startBtn.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("matiere", matiere)
            intent.putExtra("chapitre", chapitre)
            startActivity(intent)
        }
    }
}
