package com.example.quizmaster.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class ChangeAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_account)

        val backButton = findViewById<ImageButton>(R.id.buttonBack)
        backButton.setOnClickListener {
            finish()  // Retour à la page précédente
        }

        val buttonLogin1 = findViewById<Button>(R.id.buttonLoginAccount1)
        buttonLogin1.setOnClickListener {
            // Logique de connexion avec Alice Brunel
            // Exemple: ouvrir page principale ou charger user Alice
        }

        val buttonLogin2 = findViewById<Button>(R.id.buttonLoginAccount2)
        buttonLogin2.setOnClickListener {
            // Logique de connexion avec Sesse Boris
        }

        val buttonAddAccount = findViewById<Button>(R.id.buttonAddAccount)
        buttonAddAccount.setOnClickListener {
            // Logique ajout nouveau compte, par exemple ouvrir une page d'ajout ou inscription
        }
    }
}
