package com.example.quizmaster.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R
import com.example.quizmaster.data.QuestionRepository
import com.example.quizmaster.model.Question

class QuestionActivity : AppCompatActivity() {

    private lateinit var questions: List<Question> // ✅ variable globale
    private var currentIndex = 0
    private var score = 0

    private lateinit var timerText: TextView
    private lateinit var questionText: TextView
    private lateinit var trueBtn: Button
    private lateinit var falseBtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        QuestionRepository.loadQuestions(this)

        val chapitre = intent.getStringExtra("chapitre") ?: ""
        val matiere = intent.getStringExtra("matiere") ?: "Matière"


        questions = QuestionRepository.getRandomQuestions(chapitre, 10)

        timerText = findViewById(R.id.timerText)
        questionText = findViewById(R.id.questionText)
        trueBtn = findViewById(R.id.trueBtn)
        falseBtn = findViewById(R.id.falseBtn)
        val stopBtn = findViewById<Button>(R.id.btnStopQuiz)
        stopBtn.setOnClickListener {
            val chapitre = intent.getStringExtra("chapitre") ?: "Chapitre inconnu"
            val matiere = intent.getStringExtra("matiere") ?: "Matière inconnue"

            val intent = Intent(this, QuizDayActivity::class.java)
            intent.putExtra("chapitre", chapitre)
            intent.putExtra("matiere", matiere)
            startActivity(intent)
            finish()
        }


        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = "Temps restant : ${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                finishQuiz()
            }
        }.start()

        showQuestion()

        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }
    }

    private fun showQuestion() {
        if (currentIndex < questions.size) {
            questionText.text = questions[currentIndex].question // ✅ Utilisation propre
        } else {
            finishQuiz()
        }
    }

    private fun checkAnswer(answer: Boolean) {
        val correct = questions[currentIndex].answer // ✅ accès via la data class
        if (answer == correct) score++
        currentIndex++
        showQuestion()
    }

    /*private fun finishQuiz() {
        val prefs = getSharedPreferences("QUIZ_APP", Context.MODE_PRIVATE)
        val totalScore = prefs.getInt("totalScore", 0)
        prefs.edit().putInt("totalScore", totalScore + score).apply()

        Toast.makeText(this, "Quiz terminé ! Score : $score", Toast.LENGTH_LONG).show()
        finish()
    }*/

    private fun finishQuiz() {
        val prefs = getSharedPreferences("QUIZ_APP", Context.MODE_PRIVATE)
        val matiere = intent.getStringExtra("matiere") ?: "Inconnue"  // Récupérer la matière

        // Récupérer le score de la matière si déjà existant
        val previousScore = prefs.getInt(matiere, 0)

        // Mettre à jour le score pour cette matière
        prefs.edit().putInt(matiere, previousScore + score).apply()

        // Mettre à jour le score total (si tu veux toujours le conserver)
        val totalScore = prefs.getInt("totalScore", 0)
        prefs.edit().putInt("totalScore", totalScore + score).apply()

        Toast.makeText(this, "Quiz terminé ! Score : $score", Toast.LENGTH_LONG).show()
        finish()
    }

}
