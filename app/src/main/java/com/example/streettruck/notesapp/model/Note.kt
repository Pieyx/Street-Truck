package com.example.streettruck.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class Note(

    @ColumnInfo(name = "note_name")
    val title:String
    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null
}