package com.example.quizmaster.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmaster.R

class ChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        val spinner = findViewById<Spinner>(R.id.spinnerChapitres)
        val btnValider = findViewById<Button>(R.id.btnValiderChapitre)
        val titleText = findViewById<TextView>(R.id.textChoice)

        // ✅ Matière récupérée depuis HomeActivity
        val selectedMatiere = intent.getStringExtra("matiere") ?: ""
        titleText.text = "Choisis un chapitre de $selectedMatiere"

        val chapitres = when (selectedMatiere) {
            "Mathématiques" -> listOf(
                "2nde - Nombres et calculs",
                "2nde - Géométrie plane et repérage",
                "2nde - Statistiques descriptives",
                "2nde - Fonctions numériques",
                "2nde - Équations et inéquations",
                "2nde - Probabilités",
                "2nde - Vecteurs et géométrie dans l’espace",
                "1ère - Fonctions polynômes du second degré",
                "1ère - Dérivation et applications",
                "1ère - Statistiques et probabilités",
                "1ère - Suites numériques",
                "1ère - Trigonométrie",
                "1ère - Géométrie analytique",
                "Term - Limites, continuité et dérivabilité",
                "Term - Intégrales et calcul d’aires",
                "Term - Lois de probabilité",
                "Term - Fonctions exponentielles et logarithmes",
                "Term - Suites et séries",
                "Term - Nombres complexes"
            )
            "Histoire" -> listOf(
                "2nde - L'invention de la citoyenneté dans le monde antique",
                "2nde - Humanisme, réformes et conflits religieux",
                "2nde - Monarchies absolues et Lumières",
                "1ère - La Première Guerre mondiale",
                "1ère - L’entre-deux-guerres et les régimes totalitaires",
                "1ère - La Seconde Guerre mondiale",
                "1ère - Le monde depuis 1945",
                "Term - La Ve République",
                "Term - La guerre froide",
                "Term - La décolonisation",
                "Term - La mondialisation en fonctionnement",
                "Term - Les enjeux du monde contemporain"
            )
            "SVT" -> listOf(
                "2nde - La cellule, unité structurale du vivant",
                "2nde - Reproduction et maintien des espèces",
                "2nde - L'organisme en interaction avec son environnement",
                "1ère - Génétique et évolution",
                "1ère - L’immunité et les défenses de l’organisme",
                "1ère - Reproduction humaine et santé",
                "1ère - Variation génétique et santé",
                "Term - Évolution et diversité du vivant",
                "Term - Le brassage génétique et sa contribution à la diversité génétique",
                "Term - Le climat du futur",
                "Term - Génétique et biotechnologies",
                "Term - Écosystèmes et services écosystémiques"
            )
            "Français" -> listOf(
                "2nde - Genres et registres littéraires",
                "2nde - Argumentation directe et indirecte",
                "2nde - Étude de textes et parcours de lecture",
                "2nde - Poésie et figures de style",
                "1ère - Commentaire littéraire",
                "1ère - Dissertation et écriture d’invention",
                "1ère - Oral du bac",
                "1ère - Parcours d’œuvres (littérature française et étrangère)",
                "Term - Histoire littéraire et grands mouvements",
                "Term - Littérature et société",
                "Term - Théâtre classique et moderne",
                "Term - Littérature engagée",
                "Term - Étude de l’image et supports contemporains"
            )
            "Anglais" -> listOf(
                "2nde - Everyday life",
                "2nde - Vocabulary building",
                "2nde - Grammar and sentence structure",
                "2nde - Describing and narrating",
                "1ère - Expressing opinion and debating",
                "1ère - Anglo-saxon cultures and history",
                "1ère - Media and communication",
                "1ère - Writing techniques and oral expression",
                "Term - Power and citizenship",
                "Term - Global challenges",
                "Term - Scientific innovation and responsibility",
                "Term - Literature and cultural identity",
                "Term - Spaces and exchanges"
            )
            "Physique" -> listOf(
                "2nde - Énergie et puissance",
                "2nde - Lumière et vision",
                "2nde - Mouvements et forces",
                "2nde - Électricité",
                "1ère - Ondes et signaux périodiques",
                "1ère - Cinématique et dynamique",
                "1ère - Énergie mécanique et travail",
                "1ère - Électricité et circuits RC",
                "Term - Ondes, particules et dualité",
                "Term - Radioactivité et interactions nucléaires",
                "Term - Thermodynamique et transferts",
                "Term - Optique ondulatoire",
                "Term - Physique quantique"
            )
            "Chimie" -> listOf(
                "2nde - Constitution de la matière",
                "2nde - Réactions chimiques",
                "2nde - Solutions et concentrations",
                "1ère - Réactions acido-basiques",
                "1ère - Dosages par titrage",
                "1ère - Réactions d’oxydoréduction",
                "1ère - Cinétique chimique",
                "Term - Équilibres chimiques",
                "Term - Synthèse organique",
                "Term - Transformations chimiques et énergie",
                "Term - Analyse spectroscopique",
                "Term - Réaction et rendement"
            )
            "Géographie" -> listOf(
                "2nde - Espaces et dynamiques urbaines",
                "2nde - Territoires de la mondialisation",
                "2nde - Risques, ressources et développement durable",
                "1ère - Mondialisation et inégalités",
                "1ère - Mobilités humaines",
                "1ère - Développement des territoires",
                "1ère - Espaces productifs et métropoles",
                "Term - France et UE dans la mondialisation",
                "Term - Dynamiques des territoires français",
                "Term - Géopolitique des ressources",
                "Term - Enjeux environnementaux globaux",
                "Term - Aménagement du territoire"
            )
            "Philosophie" -> listOf(
                "Term - La conscience",
                "Term - Le désir",
                "Term - Le langage",
                "Term - Le travail et la technique",
                "Term - L’art",
                "Term - La vérité",
                "Term - La liberté",
                "Term - La justice et le droit",
                "Term - L’État",
                "Term - La religion"
            )
            "Economie" -> listOf(
                "2nde - Consommation et production",
                "2nde - Marché et formation des prix",
                "2nde - Rôle économique de l’État",
                "1ère - Entreprises et financement",
                "1ère - État et politique économique",
                "1ère - Marché du travail",
                "1ère - Croissance et crises",
                "Term - Mondialisation et commerce international",
                "Term - Économie du développement durable",
                "Term - Inégalités économiques et sociales",
                "Term - Politiques économiques et sociales",
                "Term - Gouvernance économique mondiale"
            )
            else -> listOf("Aucun chapitre disponible")
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, chapitres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnValider.setOnClickListener {
            val chapitreChoisi = spinner.selectedItem.toString()
            val chapitreComplet = chapitreChoisi  // On garde le nom tel quel
            val matiere = intent.getStringExtra("matiere")


            val intent = Intent(this, QuizDayActivity::class.java)
            intent.putExtra("chapitre", chapitreComplet)
            intent.putExtra("matiere", matiere)
                startActivity(intent)
        }
    }
}
