package com.example.streettruck.notesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.streettruck.notesapp.repository.NoteRepository

class NoteViewModelFactory(private val repository: NoteRepository)
    :ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}