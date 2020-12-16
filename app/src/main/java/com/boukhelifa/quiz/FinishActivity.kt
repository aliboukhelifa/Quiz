package com.boukhelifa.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val username = intent.getStringExtra(Constantes.USER_NAME)
        tvName.text = username
        val totalQuestions = intent.getIntExtra(Constantes.TOTAL_QUESTIONS, 0)
        val bonnesReponses = intent.getIntExtra(Constantes.BONNE_REPONSES, 0)

        tvScore.text = "Votre score est de $bonnesReponses / $totalQuestions"

        btnRejouer.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}