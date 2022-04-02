package com.example.notatnikdemo.data

import androidx.lifecycle.LiveData
import com.example.notatnikdemo.data.Note
import com.example.notatnikdemo.data.NoteDao

class NoteRepository(private val noteDao : NoteDao) {
    val readAllData: LiveData<List<Note>> = noteDao.readAllData()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }
}