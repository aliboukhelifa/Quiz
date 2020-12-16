package com.boukhelifa.quiz

data class Question (
    val id: Int,
    val question: String,
    val reponse1: String,
    val reponse2: String,
    val reponse3: String,
    val reponse4: String,
    val bonneReponse: Int
)