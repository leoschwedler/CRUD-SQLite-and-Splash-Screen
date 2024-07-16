package com.example.crudsqlite.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.crudsqlite.model.Note
import com.example.crudsqlite.util.Const

class NoteDAO(context: Context) : INoteDAO {

    private val write = DataBaseHelper(context).writableDatabase
    private val read = DataBaseHelper(context).readableDatabase

    override fun create(note: Note): Boolean {
        val values = ContentValues().apply {
            put("${Const.COLUMN_TITLE}", note.title)
            put("${Const.COLUMN_DESCRIPTION}", note.description)

        }
        try {
            write.insert(
                Const.TABLE_NAME, null, values
            )
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    override fun read(): List<Note> {
        val lisNotes = mutableListOf<Note>()
        val sql =
            "SELECT ${Const.COLUMN_ID_NOTE},${Const.COLUMN_TITLE}, ${Const.COLUMN_DESCRIPTION} from ${Const.TABLE_NAME};"
        val cursor = read.rawQuery(sql, null)
        val indexIdNote = cursor.getColumnIndex(Const.COLUMN_ID_NOTE)
        val indexTitle = cursor.getColumnIndex(Const.COLUMN_TITLE)
        val indexDescription = cursor.getColumnIndex(Const.COLUMN_DESCRIPTION)
        while (cursor.moveToNext()) {
            val idNote = cursor.getInt(indexIdNote)
            val title = cursor.getString(indexTitle)
            val description = cursor.getString(indexDescription)
            lisNotes.add(Note(idNote, title, description))
        }
        return lisNotes
    }

    override fun update(note: Note): Boolean {
        val args = arrayOf(note.idNote.toString())
        val content = ContentValues().apply {
            put("${Const.COLUMN_TITLE}", note.title)
            put("${Const.COLUMN_DESCRIPTION}", note.description)
        }
        try {
            write.update(
                Const.TABLE_NAME,
                content,
                "${Const.COLUMN_ID_NOTE} = ?",
                args
            )
            Log.i("info_db", "Sucesso ao atualizar note")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao atualizar note")
            return false
        }
        return true
    }

    override fun delete(idTask: Int): Boolean {
        val args = arrayOf(idTask.toString())
        try {
            write.delete(Const.TABLE_NAME, "${Const.COLUMN_ID_NOTE} = ?", args)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }
}