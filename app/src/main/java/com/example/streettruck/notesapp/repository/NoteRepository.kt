package com.example.streettruck.notesapp.repository

import com.example.streettruck.notesapp.db.NoteDatabase
import com.example.streettruck.notesapp.model.Note

class NoteRepository(private val db:NoteDatabase) {

    suspend fun upsert(item: Note)=db.getNoteDao().upsert(item)
    suspend fun delete(item: Note)=db.getNoteDao().delete(item)
    fun getAllNote()=db.getNoteDao().getAllNote()
}