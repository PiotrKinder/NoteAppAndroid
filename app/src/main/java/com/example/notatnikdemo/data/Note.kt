package com.example.notatnikdemo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note (
    @PrimaryKey (autoGenerate = true) val id: Int,
    val topic: String,
    val text: String)