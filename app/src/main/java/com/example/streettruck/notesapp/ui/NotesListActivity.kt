package com.example.streettruck.notesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streettruck.R
import com.example.streettruck.databinding.ActivityNotesListBinding
import com.example.streettruck.notesapp.model.Note
import com.example.streettruck.notesapp.utils.NoteAdapter

class NotesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotesListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteListSingleItem = mutableListOf(Note("Go To Gym"))
        val adapter = NoteAdapter(noteListSingleItem)

        binding.rvNotes.adapter = adapter
        binding.rvNotes.layoutManager = LinearLayoutManager(this)

        binding.btnAddNote.setOnClickListener {

            val newNoteTitle = binding.etAddNote.text.toString() // Getting the notes as text
            val newNote = Note(newNoteTitle) // new noteItem

            noteListSingleItem.add(newNote)
            adapter.notifyDataSetChanged()
            binding.etAddNote.text.clear()
        }
    }
}