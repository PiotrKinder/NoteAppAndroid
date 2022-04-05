package com.example.notatnikdemo.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notatnikdemo.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(noteModel: Note)

    @Update
    suspend fun updateNote(noteModel: Note)

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Note>>
}