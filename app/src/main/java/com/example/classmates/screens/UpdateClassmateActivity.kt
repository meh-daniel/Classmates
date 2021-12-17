package com.example.classmates.screens

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.classmates.databinding.ActivityUpdateClassmateBinding

class UpdateClassmateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateClassmateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateClassmateBinding.inflate(layoutInflater).also { setContentView(it.root) }
    }

}