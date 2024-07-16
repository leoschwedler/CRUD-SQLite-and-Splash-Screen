package com.example.crudsqlite.model

import java.io.Serializable

data class Note(
    val idNote: Int,
    val title: String,
    val description: String
): Serializable
