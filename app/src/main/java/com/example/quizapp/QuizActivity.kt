package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityLoginBinding
import com.example.quizapp.databinding.ActivityQuizBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var questions: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questions = ArrayList<QuestionModel>()
        Firebase.firestore.collection("Quiz").get().addOnSuccessListener {
            doct->
            questions.clear()
            for (i in doct.documents){
                var questionModel = i.toObject(QuestionModel::class.java)
                questions.add(questionModel!!)
            }
            binding.quizQuestion.setText(questions.get(0).question)
            binding.opt1.setText(questions.get(0).opt1)
            binding.opt2.setText(questions.get(0).opt2)
            binding.opt3.setText(questions.get(0).opt3)
            binding.opt4.setText(questions.get(0).opt4)
        }
//        questions.add(QuestionModel("Q : who is the prime energy drink founder?","logan paul","jake paul","paul walker","amala paul","logan paul"))
//        questions.add(QuestionModel("who is the prime energy drink founder","logan paul","jake paul","paul walker","amala paul","logan paul"))
//        questions.add(QuestionModel("who is the prime energy drink founder","jake paul","logan paul","paul walker","amala paul","logan paul"))
//        questions.add(QuestionModel("who is the prime energy drink founder","logan paul","jake paul","paul walker","amala paul","logan paul"))
//        questions.add(QuestionModel("who is the prime energy drink founder","logan paul","jake paul","paul walker","amala paul","logan paul"))

        binding.opt1.setOnClickListener{
            nextData(binding.opt1.text.toString())
        }
        binding.opt2.setOnClickListener{
            nextData(binding.opt2.text.toString())
        }
        binding.opt3.setOnClickListener{
            nextData(binding.opt3.text.toString())
        }
        binding.opt4.setOnClickListener{
            nextData(binding.opt4.text.toString())
        }



    }

    private fun nextData(i: String) {

        if(count<questions.size){
            if(questions[count].answer == i){
                score++
            }
        }
        count++
        if(count>=questions.size){
            val intent = Intent(this,ScoreActivity::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()
        }
        else {

            binding.quizQuestion.setText(questions.get(count).question)
            binding.opt1.setText(questions.get(count).opt1)
            binding.opt2.setText(questions.get(count).opt2)
            binding.opt3.setText(questions.get(count).opt3)
            binding.opt4.setText(questions.get(count).opt4)
        }
    }
}