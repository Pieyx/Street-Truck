package com.example.streettruck.authsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.streettruck.databinding.ActivityLoginBinding
import com.example.streettruck.notesapp.ui.NotesListActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnLogin.setOnClickListener{
            val intent = Intent(this, NotesListActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.txRegister.setOnClickListener{
            val intent = Intent(this, RegisterationActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}