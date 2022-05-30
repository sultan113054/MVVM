package com.assignment.imdbmovie.presentation.di.database

import android.content.Context
import androidx.room.Room
import com.assignment.imdbmovie.data.db.IMDBDatabase
import com.assignment.imdbmovie.data.db.TopMoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideIMDBMovieDataBase(context: Context): IMDBDatabase {
        return Room.databaseBuilder(context, IMDBDatabase::class.java, "imdb_database").build()
    }

    @Singleton
    @Provides
    fun provideTopMoviesDao(imdbDatabase: IMDBDatabase):TopMoviesDao{
        return imdbDatabase.topMoviesDao()
    }
}