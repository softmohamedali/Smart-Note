package com.example.my_poky.data

import androidx.room.*
import com.example.my_poky.data.models.MyNote
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note:MyNote)

    @Update
    suspend fun UpdateNote(note:MyNote)

    @Delete
    suspend fun deleteNote(note:MyNote)

    @Query("DELETE FROM mynotes")
    suspend fun deleteAll()

    @Query("SELECT * FROM mynotes ORDER BY id ASC")
    fun getAllNote():Flow<List<MyNote>>

    @Query("SELECT * FROM mynotes where id=:noteid")
    fun getSpeceficNote(noteid:Int):Flow<MyNote>

    @Query("SELECT * FROM mynotes WHERE title like :searchQ")
    fun searchNote(searchQ:String):Flow<List<MyNote>>

    @Query("SELECT * FROM mynotes ORDER BY CASE When priority like 'N%' then 1 When priority like 'M%' then 2 When priority like 'H%' then 3 end")
    fun getNoteLowPriority():Flow<List<MyNote>>

    @Query("SELECT * FROM mynotes ORDER BY CASE When priority like 'H%' then 1 When priority like 'M%' then 2 When priority like 'N%' then 3 end")
    fun getNoteHighPriority():Flow<List<MyNote>>





}