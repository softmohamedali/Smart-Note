package com.example.my_poky.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.my_poky.data.models.MyNote

@Database(
    entities = arrayOf(MyNote::class),
    version = 1,
    exportSchema = false
)
abstract class NoteDataBase:RoomDatabase() {
    abstract fun getDao():MyDao
}