package com.example.quizapp

import  android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.quizEmail.editText?.text.toString(),
                binding.quizPassword.editText?.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"User Created!",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this,"User creation failed!",Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}