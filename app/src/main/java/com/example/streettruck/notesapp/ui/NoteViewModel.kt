package com.example.streettruck.notesapp.ui

import androidx.lifecycle.ViewModel
import com.example.streettruck.notesapp.model.Note
import com.example.streettruck.notesapp.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) :ViewModel() {

    fun upsert(item: Note)= CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun delete(item: Note)= CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    fun getAllNote()= repository.getAllNote()
}