package com.example.notatnikdemo.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.notatnikdemo.R
import com.example.notatnikdemo.data.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var noteList= emptyList<Note>()
     class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent,false))
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem= noteList[position]
        val tvTopic: TextView = holder.itemView.findViewById(R.id.tvTopic)
        val tvContent: TextView = holder.itemView.findViewById(R.id.tvContent)
        tvTopic.text=currentItem.topic
        tvContent.text=currentItem.text
    }

    fun setData(note : List<Note>){
        this.noteList= note
        notifyDataSetChanged()
    }
}