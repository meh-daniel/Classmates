package com.example.classmates.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.classmates.R
import com.example.classmates.model.Classmate.entities.Classmate

class ClassmateAdapter: RecyclerView.Adapter<ClassmateAdapter.ClassmateViewHolder>() {
    private var classmateList: ArrayList<Classmate> = ArrayList()
    private var onClickItem : ((Classmate) ->Unit)?=null

    fun addItems(items: ArrayList<Classmate>) {
        this.classmateList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClassmateViewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.classmate_item, parent, false)
    )

    override fun onBindViewHolder(holder: ClassmateViewHolder, position: Int) {
        var classmate= classmateList[position]
        holder.bindView(classmate = classmate)
    }

    override fun getItemCount(): Int {
        return classmateList.size
    }

    class ClassmateViewHolder(view:View): RecyclerView.ViewHolder(view){
        private var id = view.findViewById<TextView>(R.id.tv_id)
        private var name = view.findViewById<TextView>(R.id.tv_name)
        private var surname = view.findViewById<TextView>(R.id.tv_surname)
        private var patronymic = view.findViewById<TextView>(R.id.tv_email)
        private var dateTimeInsert = view.findViewById<TextView>(R.id.tv_password)

        fun bindView(classmate: Classmate){
            id.text = classmate.id.toString()
            name.text = classmate.name
            surname.text = classmate.surname
            patronymic.text = classmate.patronymic
            dateTimeInsert.text = classmate.dateTimeInsert
        }
    }

}