package com.example.quizmaster.ui.theme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class ProfileActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1 // Code pour lancer l'intent de la galerie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Récupérer les SharedPreferences pour accéder aux scores
        val prefs = getSharedPreferences("QUIZ_APP", MODE_PRIVATE)

        // Récupérer les scores pour chaque matière
        val mathsScore = prefs.getInt("Mathématiques", 0)
        val histoireScore = prefs.getInt("Histoire", 0)
        val svtScore = prefs.getInt("SVT", 0)
        val francaisScore = prefs.getInt("Français", 0)
        val anglaisScore = prefs.getInt("Anglais", 0)
        val physiqueScore = prefs.getInt("Physique", 0)
        val chimieScore = prefs.getInt("Chimie", 0)
        val geoScore = prefs.getInt("Géographie", 0)
        val philoScore = prefs.getInt("Philosophie", 0)
        val economieScore = prefs.getInt("Economie", 0)

        // Récupérer et afficher le score total
        val totalScore = prefs.getInt("totalScore", 0)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        scoreTextView.text = "Score total : $totalScore"

        // Afficher les scores des matières
        val scoreMaths = findViewById<TextView>(R.id.scoreMaths)
        scoreMaths.text = "Mathématiques : $mathsScore"

        val scoreHistoire = findViewById<TextView>(R.id.scoreHistoire)
        scoreHistoire.text = "Histoire : $histoireScore"

        val scoreSVT = findViewById<TextView>(R.id.scoreSVT)
        scoreSVT.text = "SVT : $svtScore"

        val scoreFrançais = findViewById<TextView>(R.id.scoreFrançais)
        scoreFrançais.text = "Français : $francaisScore"

        val scoreAnglais = findViewById<TextView>(R.id.scoreAnglais)
        scoreAnglais.text = "Anglais : $anglaisScore"

        val scorePhysique = findViewById<TextView>(R.id.scorePhysique)
        scorePhysique.text = "Physique : $physiqueScore"

        val scoreChimie = findViewById<TextView>(R.id.scoreChimie)
        scoreChimie.text = "Chimie : $chimieScore"

        val scoreGeo = findViewById<TextView>(R.id.scoreGeo)
        scoreGeo.text = "Géographie : $geoScore"

        val scorePhilo = findViewById<TextView>(R.id.scorePhilosophie)
        scorePhilo.text = "Philosophie : $philoScore"

        val scoreEconomie = findViewById<TextView>(R.id.scoreEconomie)
        scoreEconomie.text = "Economie : $economieScore"

        // OnClickListener pour changer la photo de profil
        val imageProfile = findViewById<ImageView>(R.id.imageProfile)
        imageProfile.setOnClickListener {
            openGallery()  // Ouvre la galerie pour changer la photo
        }
    }

    // Ouvre la galerie pour choisir une image
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // Récupère le résultat de la galerie
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST) {
            val imageUri: Uri? = data?.data // URI de l'image choisie
            val imageProfile = findViewById<ImageView>(R.id.imageProfile)
            imageProfile.setImageURI(imageUri) // Met à jour l'image
        }
    }
}


/*package com.example.quizmaster.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class ProfileActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Récupérer les SharedPreferences pour accéder aux scores
        val prefs = getSharedPreferences("QUIZ_APP", Context.MODE_PRIVATE)

        // Récupérer les scores pour chaque matière
        val mathsScore = prefs.getInt("Mathématiques", 0)
        val histoireScore = prefs.getInt("Histoire", 0)
        val svtScore = prefs.getInt("SVT", 0)
        val francaisScore = prefs.getInt("Français", 0)
        val anglaisScore = prefs.getInt("Anglais", 0)
        val physiqueScore = prefs.getInt("Physique", 0)
        val chimieScore = prefs.getInt("Chimie", 0)
        val geoScore = prefs.getInt("Géographie", 0)
        val philoScore = prefs.getInt("Philosophie", 0)
        val economieScore = prefs.getInt("Economie", 0)

        // Récupérer et afficher le score total
        val totalScore = prefs.getInt("totalScore", 0)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        scoreTextView.text = "Score total : $totalScore"

        // Afficher les scores des matières
        val scoreMaths = findViewById<TextView>(R.id.scoreMaths)
        scoreMaths.text = "Mathématiques : $mathsScore"

        val scoreHistoire = findViewById<TextView>(R.id.scoreHistoire)
        scoreHistoire.text = "Histoire : $histoireScore"

        val scoreSVT = findViewById<TextView>(R.id.scoreSVT)
        scoreSVT.text = "SVT : $svtScore"

        val scoreFrançais = findViewById<TextView>(R.id.scoreFrançais)
        scoreFrançais.text = "Français : $francaisScore"

        val scoreAnglais = findViewById<TextView>(R.id.scoreAnglais)
        scoreAnglais.text = "Anglais : $anglaisScore"

        val scorePhysique = findViewById<TextView>(R.id.scorePhysique)
        scorePhysique.text = "Physique : $physiqueScore"

        val scoreChimie = findViewById<TextView>(R.id.scoreChimie)
        scoreChimie.text = "Chimie : $chimieScore"

        val scoreGeo = findViewById<TextView>(R.id.scoreGeo)
        scoreGeo.text = "Géographie : $geoScore"

        val scorePhilo = findViewById<TextView>(R.id.scorePhilosophie)
        scorePhilo.text = "Philosophie : $philoScore"

        val scoreEconomie = findViewById<TextView>(R.id.scoreEconomie)
        scoreEconomie.text = "Economie : $economieScore"
    }
}
*/
