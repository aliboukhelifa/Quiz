package com.boukhelifa.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mBonnesReponses: Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName = intent.getStringExtra(Constantes.USER_NAME)

        mQuestionList = Constantes.getQuestions()

       setQuestion()

        tvReponse1.setOnClickListener(this)
        tvReponse2.setOnClickListener(this)
        tvReponse3.setOnClickListener(this)
        tvReponse4.setOnClickListener(this)
        btnValider.setOnClickListener(this)
    }

    private fun setQuestion(){
        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size){
            btnValider.text = "C'est fini"
        }else{
            btnValider.text = "Valider"
        }

        progressBar.progress = mCurrentPosition
        tvProgressBar.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuestion.text = question!!.question
        tvReponse1.text = question.reponse1
        tvReponse2.text = question.reponse2
        tvReponse3.text = question.reponse3
        tvReponse4.text = question.reponse4

    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tvReponse1)
        options.add(1, tvReponse2)
        options.add(2, tvReponse3)
        options.add(3, tvReponse4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7C7A02"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.bg)
        }
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvReponse1 -> {
                selectedOptionView(tvReponse1, 1)
            }
            R.id.tvReponse2 -> {
                selectedOptionView(tvReponse2, 2)
            }
            R.id.tvReponse3 -> {
                selectedOptionView(tvReponse3, 3)
            }
            R.id.tvReponse4 -> {
                selectedOptionView(tvReponse4, 4)
            }
            R.id.btnValider -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else -> {
                            val intent = Intent(this, FinishActivity::class.java)
                            intent.putExtra(Constantes.USER_NAME, mUserName)
                            intent.putExtra(Constantes.BONNE_REPONSES, mBonnesReponses)
                            intent.putExtra(Constantes.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.bonneReponse != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrongbg)
                    }else{
                        mBonnesReponses++
                    }
                    answerView(question.bonneReponse, R.drawable.correctbg)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btnValider.text = "C'est fini !"
                    }else{
                        btnValider.text = "Suivant"
                    }
                    mSelectedOptionPosition = 0

                }

            }

        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tvReponse1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvReponse2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvReponse3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvReponse4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.selectedbg)
    }


}

