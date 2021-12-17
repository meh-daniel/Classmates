package com.example.classmates.model.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppSQLiteHelper(
    private val applicationContext : Context
    ) : SQLiteOpenHelper(applicationContext, AppSQLiteContract.InfoDataBase.DATA_BASE_NAME,
    null, AppSQLiteContract.InfoDataBase.DATA_BASE_VERSION) {

    override fun onCreate(p0: SQLiteDatabase?) {
        val sql = applicationContext.assets.open("db_init.sql").bufferedReader().use {
            it.readText()
        }
        sql.split(";")
            .filter { it.isNotBlank() }
            .forEach{ p0?.execSQL(it)}
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}