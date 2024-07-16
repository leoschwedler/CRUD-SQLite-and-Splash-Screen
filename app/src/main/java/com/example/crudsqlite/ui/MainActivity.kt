package com.example.crudsqlite.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudsqlite.adapter.NoteAdapter
import com.example.crudsqlite.database.NoteDAO
import com.example.crudsqlite.databinding.ActivityMainBinding
import com.example.crudsqlite.model.Note

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var taskDAO: NoteDAO
    var listNotes = emptyList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(binding.root)

        initializeRecyclerView()
        binding.floatingActionButtonAdd.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        attListTask()
    }

    private fun attListTask() {
        taskDAO = NoteDAO(this)
        listNotes = taskDAO.read()
        noteAdapter.refreshNote(this.listNotes)
    }

    private fun initializeRecyclerView() {
        noteAdapter = NoteAdapter({ id -> alerBuilder(id) }, { task -> edit(task) })
        binding.RecyclerView.adapter = noteAdapter
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun edit(note: Note) {
        val intent = Intent(this, AddNoteActivity::class.java)
        intent.putExtra("note", note)
        startActivity(intent)
    }

    private fun alerBuilder(it: Int) {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Confirm Deletion")
        alertBuilder.setMessage("Are you sure you want to delete the task?")
        alertBuilder.setPositiveButton("Yes") { _, _ ->
            if (taskDAO.delete(it)) {
                attListTask()
                Toast.makeText(this, "Task removed successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error removing task", Toast.LENGTH_SHORT).show()
            }
        }
        alertBuilder.setNegativeButton("No") { _, _ ->

        }
        alertBuilder.create().show()
    }
}