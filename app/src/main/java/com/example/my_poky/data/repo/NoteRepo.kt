package com.example.my_poky.data.repo

import com.example.my_poky.data.MyDao
import com.example.my_poky.data.models.MyNote
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class NoteRepo @Inject constructor(
    var noteDao: MyDao
){
    val getAllNote=noteDao.getAllNote()
    val getNoteHighPrio=noteDao.getNoteHighPriority()
    val getNoteLowPrio=noteDao.getNoteLowPriority()

    suspend fun insertNote(myNote: MyNote)=
        noteDao.insertNote(myNote)

    suspend fun upDateNote(myNote: MyNote)=
        noteDao.UpdateNote(myNote)

    suspend fun deleAllNote()=
        noteDao.deleteAll()

    suspend fun deleteNote(myNote: MyNote)=
        noteDao.deleteNote(myNote)

    fun searshNote(query:String)=
        noteDao.searchNote(query)


}