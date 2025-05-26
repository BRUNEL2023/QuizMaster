package com.example.quizmaster.data

import android.content.Context
import com.example.quizmaster.model.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object QuestionRepository {

    private var allQuestions: Map<String, List<Question>> = emptyMap()

    fun loadQuestions(context: Context) {
        val json = context.assets.open("questions.json")
            .bufferedReader().use { it.readText() }

        val type = object : TypeToken<Map<String, List<Question>>>() {}.type
        allQuestions = Gson().fromJson(json, type)
    }

    fun getRandomQuestions(chapitre: String, count: Int = 10): List<Question> {
        return allQuestions[chapitre]?.shuffled()?.take(count) ?: emptyList()
    }
}
