package com.example.notatnikdemo.repository

import androidx.lifecycle.LiveData
import com.example.notatnikdemo.data.NoteDao
import com.example.notatnikdemo.model.Note

class NoteRepository(private val noteDao : NoteDao) {
    val readAllData: LiveData<List<Note>> = noteDao.readAllData()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }
}