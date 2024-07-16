package com.example.crudsqlite.database

import com.example.crudsqlite.model.Note

interface INoteDAO {
    fun create(note: Note):Boolean
    fun read(): List<Note>
    fun update(note: Note):Boolean
    fun delete(idTask: Int):Boolean
}