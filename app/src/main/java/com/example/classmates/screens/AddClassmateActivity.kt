package com.example.classmates.screens

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.classmates.databinding.ActivityAddClassmateBinding
import com.example.classmates.model.Classmate.SQLiteClassmateRepository
import com.example.classmates.model.Classmate.entities.Classmate
import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.util.*

class AddClassmateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddClassmateBinding
    private lateinit var mSQLiteClassmateRepository : SQLiteClassmateRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClassmateBinding.inflate(layoutInflater).also { setContentView(it.root) }
        mSQLiteClassmateRepository = SQLiteClassmateRepository(this)
        binding.btnSave.setOnClickListener{ addUser()}
    }

    private fun addUser() {
        var name = binding.nameEdit.text.toString().trim()
        var surname = binding.surnameEdit.text.toString().trim()
        var patronymic = binding.patronymicEdit.text.toString().trim()

        var sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        var currentDate = sdf.format(Date())
        var dateTimeInsert = currentDate.toString().trim()

        val classmate = Classmate(_id = 7, _name = name, _surname = surname, _patronymic = patronymic)
        var otbet = mSQLiteClassmateRepository.addClassmate(classmate)
        Log.i("Db","$name $surname $patronymic $dateTimeInsert $otbet")
        Toast.makeText(this,"Всё прошло успешно $otbet",Toast.LENGTH_SHORT).show()
    }

}