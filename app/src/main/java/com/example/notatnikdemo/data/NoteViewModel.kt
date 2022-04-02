package com.example.notatnikdemo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notatnikdemo.data.Note
import com.example.notatnikdemo.data.NoteDatabase
import com.example.notatnikdemo.data.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Note>>
    private val repository: NoteRepository

    init {
        val noteDao= NoteDatabase.getDatabase(application).noteDao()
        repository= NoteRepository(noteDao)
        readAllData= repository.readAllData
    }

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }
}