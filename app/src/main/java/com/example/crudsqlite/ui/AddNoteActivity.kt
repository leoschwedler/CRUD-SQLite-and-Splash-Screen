package com.example.crudsqlite.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crudsqlite.database.NoteDAO
import com.example.crudsqlite.databinding.ActivityAddNoteBinding
import com.example.crudsqlite.model.Note

class AddNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddNoteBinding.inflate(layoutInflater) }
    private lateinit var taskDAO: NoteDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        taskDAO = NoteDAO(this)
        var note: Note? = null
        val bundle = intent.extras
        if (bundle != null) {
            note = bundle.getSerializable("note") as Note
            binding.editTextTitle.setText(note.title)
            binding.editTextDescription.setText(note.description)
        }


        binding.imageViewSave.setOnClickListener {
            if (binding.editTextTitle.text.isNotEmpty() && binding.editTextDescription.text.isNotEmpty()) {
                if (note != null) {
                    edit(note)
                } else {
                    save()
                }
            } else {
                Toast.makeText(this, "Error creating a task", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun edit(note: Note) {
        val title = binding.editTextTitle.text.toString()
        val description = binding.editTextDescription.text.toString()
        val noteAtt = Note(note.idNote, title,description)
        if (taskDAO.update(noteAtt)) {
            Toast.makeText(this, "Successfully updated", Toast.LENGTH_SHORT).show()
            finish()
        }else {
            Toast.makeText(this, "Error updating", Toast.LENGTH_SHORT).show()
        }
    }

    fun save() {
        val title = binding.editTextTitle.text.toString()
        val description = binding.editTextDescription.text.toString()
        val note = Note(-1, title,description)
        if (taskDAO.create(note)) {
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}