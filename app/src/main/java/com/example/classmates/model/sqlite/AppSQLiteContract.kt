package com.example.classmates.model.sqlite

object AppSQLiteContract {

    object InfoDataBase{
        const val DATA_BASE_NAME = "dbClassmates"
        const val DATA_BASE_VERSION = 1
    }

    object ClassmatesTable{
        const val TABLE_NAME = "Classmates"
        const val COLUMN_ID = "Id"
        const val COLUMN_NAME = "Name"
        const val COLUMN_SURNAME = "Surname"
        const val COLUMN_PATRONYMIC = "Patronymic"
        const val COLUMN_DATE_TIME_INSERT = "DateTimeInsert"
    }

}