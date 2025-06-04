    package com.example.quizmaster.ui.theme

    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import com.example.quizmaster.R
    import com.google.firebase.auth.FirebaseAuth
    import com.google.firebase.auth.ktx.auth
    import com.google.firebase.ktx.Firebase

    class HomeActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home)

            // Retrieve user info from Firebase
            val auth = FirebaseAuth.getInstance()
            val user = auth.currentUser
            val greetingText = findViewById<TextView>(R.id.greetingText)
            greetingText.text = "Bonjour, ${user?.displayName ?: "Utilisateur"} !"

            val learningText = findViewById<TextView>(R.id.learningText)
            learningText.text = "Qu'est-ce que tu veux apprendre aujourd'hui ?"


            val imgProfile = findViewById<ImageView>(R.id.imgProfile)
            val imgSettings = findViewById<ImageView>(R.id.imgSettings)
            val imgLogin = findViewById<ImageView>(R.id.imgLogin)
            val btnMaths = findViewById<Button>(R.id.btnMaths)
            val btnHistoire = findViewById<Button>(R.id.btnHistoire)
            val btnSVT = findViewById<Button>(R.id.btnSVT)
            val btnFrançais = findViewById<Button>(R.id.btnFrançais)
            val btnAnglais = findViewById<Button>(R.id.btnAnglais)
            val btnPhysique = findViewById<Button>(R.id.btnPhysique)
            val btnChimie = findViewById<Button>(R.id.btnChimie)
            val btnGéographie = findViewById<Button>(R.id.btnGéographie)
            val btnPhilosophie = findViewById<Button>(R.id.btnPhilosophie)
            val btnEconomie = findViewById<Button>(R.id.btnEconomie)


            imgProfile.setOnClickListener {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }

            imgSettings.setOnClickListener {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }

            imgLogin.setOnClickListener {
                val auth = Firebase.auth
                auth.signOut()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()  // Close the current activity
            }

            btnMaths.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Mathématiques")
                startActivity(intent)
            }

            btnHistoire.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Histoire")
                startActivity(intent)
            }

            btnSVT.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "SVT")
                startActivity(intent)
            }

            btnFrançais.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Français")
                startActivity(intent)
            }

            btnAnglais.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Anglais")
                startActivity(intent)
            }

            btnPhysique.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Physique")
                startActivity(intent)
            }

            btnChimie.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Chimie")
                startActivity(intent)
            }

            btnGéographie.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Géographie")
                startActivity(intent)
            }

            btnPhilosophie.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Philosophie")
                startActivity(intent)
            }

            btnEconomie.setOnClickListener {
                val intent = Intent(this, ChoiceActivity::class.java)
                intent.putExtra("matiere", "Economie")
                startActivity(intent)
            }
        }
    }
