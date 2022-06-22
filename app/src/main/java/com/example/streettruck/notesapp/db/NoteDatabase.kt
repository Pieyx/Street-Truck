package com.example.streettruck.notesapp.db

import android.content.Context
import androidx.room.*
import com.example.streettruck.notesapp.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "NoteDB.db"
            ).build()
    }

}