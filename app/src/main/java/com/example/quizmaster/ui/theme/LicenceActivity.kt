package com.example.quizmaster.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class LicenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_licence)
        supportActionBar?.title = "Licence"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
