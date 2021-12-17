package com.example.classmates.model.Classmate

import com.example.classmates.model.Classmate.entities.Classmate
import java.util.concurrent.Flow

/**
 *Репозиторий для класса одногруппники: добавление, получения, удаления и обновления
 */
interface ClassmateRepository {

    fun addClassmate(classmate: Classmate) : Boolean

    fun getClassmates(): ArrayList<Classmate>

    fun updateLastClassmate(id : Long, name: String, surname: String, patronymic : String) : Boolean
}