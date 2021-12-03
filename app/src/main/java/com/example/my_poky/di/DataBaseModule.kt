package com.example.my_poky.di

import android.content.Context
import androidx.room.Room
import com.example.my_poky.data.NoteDataBase
import com.example.my_poky.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context)=
        Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            Constants.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideDao(database:NoteDataBase)=database.getDao()
}