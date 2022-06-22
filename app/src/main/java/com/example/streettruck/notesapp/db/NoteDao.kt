package com.example.streettruck.notesapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.streettruck.notesapp.model.Note

@Dao // Data access object
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert (item: Note)

    @Delete
    fun delete (item: Note)

    @Query("SELECT * FROM Note")
    fun getAllNote(): LiveData<List<Note>>
}