package com.example.streettruck.notesapp.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streettruck.databinding.ItemNoteBinding
import com.example.streettruck.notesapp.model.Note
import com.example.streettruck.notesapp.ui.NoteViewModel

class NoteAdapter(var notes:List<Note>, private val viewModel: NoteViewModel) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.apply {
            txNoteTitle.text = notes[position].title
            ivNoteDelete.setOnClickListener {
                viewModel.delete(notes[position])
            }
        }
    }

    override fun getItemCount(): Int {
       return notes.size
    }
}