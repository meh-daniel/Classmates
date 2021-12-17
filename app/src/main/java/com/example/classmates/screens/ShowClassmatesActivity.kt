package com.example.classmates.screens

import android.os.Bundle
import android.os.PersistableBundle
import android.os.strictmode.SqliteObjectLeakedViolation
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classmates.R
import com.example.classmates.adapters.ClassmateAdapter
import com.example.classmates.databinding.ActivityShowClassmetesBinding
import com.example.classmates.model.Classmate.SQLiteClassmateRepository
import com.example.classmates.model.Classmate.entities.Classmate

class ShowClassmatesActivity : AppCompatActivity(){

    private lateinit var bind : ActivityShowClassmetesBinding
    private var adapter : ClassmateAdapter? = null
    private lateinit var mSQLiteClassmateRepository :SQLiteClassmateRepository
    private var classmate : Classmate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityShowClassmetesBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initRecycleView()
        mSQLiteClassmateRepository = SQLiteClassmateRepository(this)
        getStudents()
    }

    private fun initRecycleView(){
        bind.recycleView.layoutManager = LinearLayoutManager(this)
        adapter = ClassmateAdapter()
        bind.recycleView.adapter = adapter
    }

    private fun getStudents(){
        val classmates = mSQLiteClassmateRepository.getClassmates()
        adapter?.addItems(classmates)
    }

}