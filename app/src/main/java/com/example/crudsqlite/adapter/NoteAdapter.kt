package com.example.crudsqlite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.crudsqlite.databinding.NoteItemBinding
import com.example.crudsqlite.model.Note

class NoteAdapter(val onclickRemove: (Int) -> Unit,
                  val onclickEdit: (Note) -> Unit) :
    RecyclerView.Adapter<NoteAdapter.TaskViewHolder>() {


    private var listaNote: List<Note> = emptyList()

    fun refreshNote(list: List<Note>) {
        listaNote = list
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(val binding: NoteItemBinding) : ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.textViewTitle.text = note.title
            binding.textViewDescription.text = note.description
            binding.imageViewDelete.setOnClickListener {
                onclickRemove(note.idNote)
            }
            binding.imageViewEditar.setOnClickListener {
                onclickEdit(note)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = listaNote.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val note = listaNote[position]
        holder.bind(note)
    }
}