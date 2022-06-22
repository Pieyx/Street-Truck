package com.example.streettruck.notesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streettruck.R
import com.example.streettruck.databinding.ActivityNotesListBinding
import com.example.streettruck.notesapp.db.NoteDatabase
import com.example.streettruck.notesapp.model.Note
import com.example.streettruck.notesapp.repository.NoteRepository
import com.example.streettruck.notesapp.utils.NoteAdapter

class NotesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotesListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesListBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val database = NoteDatabase(this)
        val repository = NoteRepository(database)
        val factory = NoteViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(NoteViewModel::class.java)
        val noteAdapter = NoteAdapter(listOf(),viewModel)
        binding.rvNotes.adapter = noteAdapter
        binding.rvNotes.layoutManager = LinearLayoutManager(this)

        viewModel.getAllNote().observe(this, Observer {
            noteAdapter.notes = it
            noteAdapter.notifyDataSetChanged()
        })
        binding.btnAddNote.setOnClickListener {
            val newNoteTitle = binding.etAddNote.text.toString() // Getting the notes as text
            viewModel.upsert(Note(newNoteTitle))
            binding.etAddNote.text.clear()
        }
    }
}