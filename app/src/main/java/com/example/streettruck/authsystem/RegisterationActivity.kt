package com.example.streettruck.authsystem


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.streettruck.databinding.ActivityRegisterationBinding
import com.example.streettruck.notesapp.ui.NotesListActivity

class RegisterationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, NotesListActivity::class.java)
            startActivity(intent)
            finish()

        }

        binding.txLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}