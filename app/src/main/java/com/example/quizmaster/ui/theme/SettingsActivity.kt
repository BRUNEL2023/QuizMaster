package com.example.quizmaster.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        findViewById<Button>(R.id.buttonChangerCompte).setOnClickListener {
            startActivity(Intent(this, ChangeAccountActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layoutNotifications).setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layoutSon).setOnClickListener {
            startActivity(Intent(this, SonActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layoutLicence).setOnClickListener {
            startActivity(Intent(this, LicenceActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.layoutChangerProfil).setOnClickListener {
            startActivity(Intent(this, ChangeProfileActivity::class.java))
        }

        findViewById<Button>(R.id.bouttondec).setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
