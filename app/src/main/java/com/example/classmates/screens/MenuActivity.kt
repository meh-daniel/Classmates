package com.example.classmates.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.classmates.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.showClassmatesButton.setOnClickListener{ onShowClassmatesPressed()}
        binding.addClassmateButton.setOnClickListener{onAddClassmatePressed()}
        binding.updateClassmateButton.setOnClickListener { onUpdateClassmatePressed() }
        binding.exitButton.setOnClickListener { onExitPressed() }
    }

    private fun onShowClassmatesPressed(){
        val intent = Intent(this, ShowClassmatesActivity::class.java)
        startActivity(intent)
    }
    private fun onAddClassmatePressed(){
        val intent = Intent(this,AddClassmateActivity::class.java)
        startActivity(intent)
    }
    private fun onUpdateClassmatePressed(){
        val intent = Intent(this, UpdateClassmateActivity::class.java)
        startActivity(intent)
    }

    private fun onExitPressed(){
        finish()
    }

}