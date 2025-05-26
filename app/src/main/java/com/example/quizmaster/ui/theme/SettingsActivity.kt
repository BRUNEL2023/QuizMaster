package com.example.quizmaster.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //  Référence au bouton avec son ID
        val boutonDec = findViewById<Button>(R.id.bouttondec)

        //  Déconnexion et retour vers Login
        boutonDec.setOnClickListener {
            Firebase.auth.signOut() // Déconnexion Firebase (si tu utilises Firebase Auth)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

