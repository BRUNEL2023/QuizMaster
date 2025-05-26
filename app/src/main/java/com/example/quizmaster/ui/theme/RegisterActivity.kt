package com.example.quizmaster.ui.theme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.MainActivity
import com.example.quizmaster.ui.theme.LoginActivity
import com.example.quizmaster.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var usernameInputLayout: TextInputLayout
    lateinit var emailInputLayout: TextInputLayout
    lateinit var passwordInputLayout: TextInputLayout
    lateinit var confirmPasswordInputLayout: TextInputLayout

    lateinit var registerBtn: Button
    lateinit var textViewAlreadyAccount: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        // Récupération des vues
        usernameInputLayout = findViewById(R.id.usernameInputLayout)
        emailInputLayout = findViewById(R.id.emailInputLayout)
        passwordInputLayout = findViewById(R.id.passwordInputLayout)
        confirmPasswordInputLayout = findViewById(R.id.confirmPasswordInputLayout)

        registerBtn = findViewById(R.id.registerButton)
        textViewAlreadyAccount = findViewById(R.id.textViewAlreadyAccount)

        registerBtn.setOnClickListener {


            // Reset erreurs
            usernameInputLayout.isErrorEnabled = false
            emailInputLayout.isErrorEnabled = false
            passwordInputLayout.isErrorEnabled = false
            confirmPasswordInputLayout.isErrorEnabled = false

            val username = usernameInputLayout.editText?.text.toString().trim()
            val email = emailInputLayout.editText?.text.toString().trim()
            val password = passwordInputLayout.editText?.text.toString()
            val confirmPassword = confirmPasswordInputLayout.editText?.text.toString()

            var valid = true

            if (username.trim().isEmpty() || password.trim().isEmpty() ||
                email.trim().isEmpty() || confirmPassword.trim().isEmpty()
            ) {
                if (email.trim().isEmpty()) {
                    emailInputLayout.error = "L'email est requis"
                    emailInputLayout.isErrorEnabled = true
                }
                if (password.trim().isEmpty()) {
                    passwordInputLayout.error = "Le mot de passe est requis"
                    passwordInputLayout.isErrorEnabled = true
                }
                if (confirmPassword.trim().isEmpty()) {
                    confirmPasswordInputLayout.error = "Le mot de passe est requis"
                    confirmPasswordInputLayout.isErrorEnabled = true
                }
                if (username.trim().isEmpty()) {
                    usernameInputLayout.error = "Le pseudo est requis"
                    usernameInputLayout.isErrorEnabled = true
                }

            } else {
                if (!confirmPassword.equals(password)) {
                    confirmPasswordInputLayout.error = "Les mots de passe ne correspondent pas"
                    confirmPasswordInputLayout.isErrorEnabled = true
                } else {
                    //Création d'un utilisateur dans le module d'authentification de firebase
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val user = hashMapOf(
                                    "username" to username,
                                    "email" to email,
                                )

                                val currentUser = auth.currentUser
                                //creation de l'utilisateur dans le module  Firestore
                                val db = Firebase.firestore
                                db.collection("users").document(currentUser!!.uid).set(user).addOnSuccessListener {
                                    Intent(this, LoginActivity::class.java).also {
                                        startActivity(it)
                                    }
                                }.addOnFailureListener {
                                    val errorMessage = task.exception?.message ?: "Erreur inconnue"
                                    usernameInputLayout.error = "Erreur : $errorMessage"
                                    usernameInputLayout.isErrorEnabled = true
                                }

                            } else {
                                // Afficher l'erreur pour debug
                                val errorMessage = task.exception?.message ?: "Erreur inconnue"
                                usernameInputLayout.error = "Erreur : $errorMessage"
                                usernameInputLayout.isErrorEnabled = true
                            }

                        }
                }


            }

        }

// Listener texte "Déjà un compte ? Se connecter"
        textViewAlreadyAccount.setOnClickListener {
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }


    }
}