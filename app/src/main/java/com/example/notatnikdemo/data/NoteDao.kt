package com.example.notatnikdemo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notatnikdemo.data.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(noteModel: Note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Note>>
}