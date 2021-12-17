package com.example.classmates.model.Classmate

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.classmates.model.Classmate.entities.Classmate
import com.example.classmates.model.sqlite.AppSQLiteContract
import com.example.classmates.model.sqlite.AppSQLiteHelper

class SQLiteClassmateRepository(
    context: Context
) : ClassmateRepository{
    val mAppSQLiteHelper= AppSQLiteHelper(context)
    var db : SQLiteDatabase? = null

    fun openDb(){
        db = mAppSQLiteHelper.writableDatabase
        Log.i("Db", "DbManager_openDb")
    }
    fun closeDb(){
        db?.close()
        Log.i("Db", "DbManager_closeDb")
    }

    override fun addClassmate(classmate: Classmate) : Boolean{
        openDb()
        return try {
            db?.insertOrThrow(
                AppSQLiteContract.ClassmatesTable.TABLE_NAME,
                null,
                contentValuesOf(
                    AppSQLiteContract.ClassmatesTable.COLUMN_ID to classmate.id,
                    AppSQLiteContract.ClassmatesTable.COLUMN_NAME to classmate.name,
                    AppSQLiteContract.ClassmatesTable.COLUMN_SURNAME to classmate.surname,
                    AppSQLiteContract.ClassmatesTable.COLUMN_PATRONYMIC to classmate.patronymic,
                    AppSQLiteContract.ClassmatesTable.COLUMN_DATE_TIME_INSERT to classmate.dateTimeInsert
                )
            )
            true
        } catch (e: SQLiteConstraintException) {
            false
        }
        closeDb()
    }

    override fun getClassmates(): ArrayList<Classmate> {
        openDb()
        val classmate : ArrayList<Classmate> = ArrayList()
        val cursor = db?.query(AppSQLiteContract.ClassmatesTable.TABLE_NAME,  null, null,
            null,null,null,null)
        Log.i("Db", "DbManager_getAllUser")
        var id : Long
        var name : String
        var surname : String
        var patronymic : String
        var dateTimeInsert : String
        with(cursor){
            while (this?.moveToNext()!!){
                Log.i("Db", "DbManager_cursorStart")
                id = getLong(getColumnIndexOrThrow(AppSQLiteContract.ClassmatesTable.COLUMN_ID))
                name = getString(getColumnIndexOrThrow(AppSQLiteContract.ClassmatesTable.COLUMN_NAME))
                surname = getString(getColumnIndexOrThrow(AppSQLiteContract.ClassmatesTable.COLUMN_SURNAME))
                patronymic = getString(getColumnIndexOrThrow(AppSQLiteContract.ClassmatesTable.COLUMN_PATRONYMIC))
                dateTimeInsert = getString(getColumnIndexOrThrow(AppSQLiteContract.ClassmatesTable.COLUMN_DATE_TIME_INSERT))
                val userM = Classmate(_id = id,_name = name, _surname = surname, _patronymic = patronymic, _dateTimeInsert = dateTimeInsert)
                classmate.add(userM)
                Log.i("Db", "DbManager_cursorFinish")
            }
        }
        return classmate
        closeDb()
    }

    override fun updateLastClassmate(
        id : Long,
        name: String,
        surname: String,
        patronymic: String
    ): Boolean {
        openDb()
        return try {
           db?.update(
               AppSQLiteContract.ClassmatesTable.TABLE_NAME,
               contentValuesOf(
                   AppSQLiteContract.ClassmatesTable.COLUMN_NAME to name,
                   AppSQLiteContract.ClassmatesTable.COLUMN_SURNAME to surname,
                   AppSQLiteContract.ClassmatesTable.COLUMN_PATRONYMIC to patronymic,
               ),
               "${AppSQLiteContract.ClassmatesTable.COLUMN_ID} + ?",
               arrayOf(id.toString())
           )
            true
        } catch (e: SQLiteConstraintException) {
            false
        }
        closeDb()
    }

    private fun findAccountIdByNameAndSurname(name: String, surname: String): Long {
        openDb()
        val cursor = db?.query(
            AppSQLiteContract.ClassmatesTable.TABLE_NAME,
            arrayOf(AppSQLiteContract.ClassmatesTable.COLUMN_ID, AppSQLiteContract.ClassmatesTable.COLUMN_SURNAME),
            "${AppSQLiteContract.ClassmatesTable.COLUMN_NAME} = ?",
            arrayOf(name ),
            null, null, null
        )
        return cursor.use {
            if (cursor?.count == 0) return 0
            cursor?.moveToFirst()
            val surname = cursor?.getString(cursor?.getColumnIndexOrThrow(AppSQLiteContract.ClassmatesTable.COLUMN_SURNAME))
            if (surname != surname) return 0

            cursor!!.getLong(cursor.getColumnIndexOrThrow(AppSQLiteContract.ClassmatesTable.COLUMN_ID))
        }
        closeDb()
    }
}