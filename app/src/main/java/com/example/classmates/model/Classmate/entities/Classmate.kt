package com.example.classmates.model.Classmate.entities

data class Classmate(
    var _name : String,
    var _surname : String,
    var _patronymic : String
){
    var id : Long? = null
    var name : String = _name
    var surname : String = _surname
    var patronymic : String = _patronymic
    var dateTimeInsert : String? = null

    constructor(_id : Long,
                _name: String,
                _surname: String,
                _patronymic: String) : this(_name, _surname, _patronymic){
        id = _id
    }

    constructor(_id : Long,
                _name: String,
                _surname: String,
                _patronymic: String,
                _dateTimeInsert: String) : this(_id, _name, _surname, _patronymic){
        dateTimeInsert = _dateTimeInsert
    }

}