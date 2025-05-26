package com.example.quizmaster.ui.theme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R
import com.example.quizmaster.ui.theme.LoginActivity
import com.example.quizmaster.ui.theme.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashScreenActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)



        // j'tilise un Handler pour définir le délai avant de passer à la prochaine activité
        Handler(Looper.getMainLooper()).postDelayed({
            // Vérifier si l'utilisateur est connecté
            val auth = Firebase.auth
            val currentUser = auth.currentUser
            if (currentUser != null) {
                // Si l'utilisateur est connecté, rediriger vers HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
            } else {
                // Si l'utilisateur n'est pas connecté, rediriger vers LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
            }
            finish() // Terminer l'activité SplashScreen
        }, 1500) // Affiche le splash screen pendant 2 secondes
    }
}
