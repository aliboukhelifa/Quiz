package com.boukhelifa.quiz

object Constantes {

    const val USER_NAME: String = "name"
    const val TOTAL_QUESTIONS: String = "total"
    const val BONNE_REPONSES: String = "bonnes_reponses"

    //Fonction qui récupère ttes les questions (de type "Question" dans une liste
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val qu1 = Question(
            1,
            "Qui est le président de la Russie ?",
            "Emmanuel Macron",
            "Vladimir Poutine",
            "Angela Merkel",
            "Donald Trump",
            2
        )
        questionsList.add(qu1)

        val qu2 = Question(
            2,
            "Quelle est la capitale de l'Algérie ?",
            "Alger",
            "Tripoli",
            "Abidjan",
            "Marseille",
            1
        )
        questionsList.add(qu2)

        val qu3 = Question(
            3,
            "En quelle année le Titanic a-t-il coulé ?",
            "1925",
            "2001",
            "1998",
            "1912",
            4
        )
        questionsList.add(qu3)

        val qu4 = Question(
            4,
            "Qui est le premier homme à avoir marcher sur la lune ?",
            "Benjamin Metaut",
            "Cristiano Ronaldo",
            "Neil Armstrong",
            "Youri Gagarine",
            3
        )
        questionsList.add(qu4)

        val qu5 = Question(
            5,
            "Quel acteur a joué James Bond dans Casino Royal ?",
            "Vin Diesel",
            "Daniel Craig",
            "Kev Adams",
            "Eva Mendes",
            2
        )
        questionsList.add(qu5)

        val qu6 = Question(
            6,
            "Quel club de foot a remporté le plus grand nombre de ligue des champions?",
            "Real Madrid",
            "Paris Saint Germain",
            "Olympique de Marseille",
            "Bayern de Munich",
            1
        )
        questionsList.add(qu6)

        val qu7 = Question(
            7,
            "Quel est le symbole chimique du cuivre ?",
            "Co",
            "Cu",
            "H20",
            "S",
            2
        )
        questionsList.add(qu7)

        val qu8 = Question(
            8,
            "Quelle est la capitale de de l'Irlande ?",
            "Moscou",
            "New York",
            "Bejaia",
            "Dublin",
            4
        )
        questionsList.add(qu8)

        val qu9 = Question(
            9,
            "Quel chanteur était connu comme The King of Pop ?",
            "John Lennon",
            "Johnny Hallyday",
            "Michael Jackson",
            "Tupac Shakur",
            3
        )
        questionsList.add(qu9)

        val qu10 = Question(
            10,
            "Quelle est la première femme à avoir reçu le prix Nobel ?",
            "Marie Curie",
            "Rosa Parks",
            "Simone Veil",
            "Lynda Seddiki",
            1
        )
        questionsList.add(qu10)

        return questionsList
    }
}