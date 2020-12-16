package com.boukhelifa.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJouer.setOnClickListener() {
            if(name.text.toString().isEmpty()){
                Toast.makeText(this, "SVP Entrez votre nom", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constantes.USER_NAME, name.text.toString())
                startActivity(intent)
                finish()
            }
        }

        fun onClickbtn_jouer(view: View) {
            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)

        }
    }
}