package com.example.quizmaster.ui.theme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.MainActivity
import com.example.quizmaster.R
import com.example.quizmaster.ui.theme.RegisterActivity
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val emailInputLayout = findViewById<TextInputLayout>(R.id.EmailInputLayout)
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.PasswordInputLayout)
        val loginRedirectButton = findViewById<Button>(R.id.loginRedirectButton)
        val loginButton = findViewById<Button>(R.id.buttonLogin)

        loginButton.setOnClickListener {
            emailInputLayout.isErrorEnabled = false
            passwordInputLayout.isErrorEnabled = false

            val email = emailInputLayout.editText?.text.toString()
            val password = passwordInputLayout.editText?.text.toString()

            if (email.trim().isEmpty() || password.trim().isEmpty()) {
                if (email.trim().isEmpty()) {
                    emailInputLayout.error = "L'email est requis"
                    emailInputLayout.isErrorEnabled = true
                }
                if (password.trim().isEmpty()) {
                    passwordInputLayout.error = "Le mot de passe est requis"
                    passwordInputLayout.isErrorEnabled = true
                }
            } else {
                signIn(email, password)
            }
        }

        loginRedirectButton.setOnClickListener {
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    fun signIn(email: String, password: String) {
        Log.d("signIn", "signIn User ...")

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            val emailInputLayout = findViewById<TextInputLayout>(R.id.EmailInputLayout)
            val passwordInputLayout = findViewById<TextInputLayout>(R.id.PasswordInputLayout)

            if (task.isSuccessful) {
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            } else {
                passwordInputLayout.error = "Authentification échouée"
                emailInputLayout.isErrorEnabled = true
                passwordInputLayout.isErrorEnabled = true
            }
        }
    }
}

