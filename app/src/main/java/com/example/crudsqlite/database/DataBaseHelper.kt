package com.example.crudsqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.crudsqlite.util.Const

class DataBaseHelper(context: Context): SQLiteOpenHelper(context, Const.DATABASE_NAME,null,Const.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS ${Const.TABLE_NAME}(\n" +
                "${Const.COLUMN_ID_NOTE} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "  ${Const.COLUMN_TITLE} VARCHAR(50),\n" +
                "  ${Const.COLUMN_DESCRIPTION} VARCHAR(150)" +
                ");"
        try {
            db?.execSQL(sql)
            Log.i("info_db", "Sucesso ao criar o banco de dados")
        }catch (e: Exception){
            e.printStackTrace()
            Log.i("info_db", "Erro ao criar o banco de dados")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}