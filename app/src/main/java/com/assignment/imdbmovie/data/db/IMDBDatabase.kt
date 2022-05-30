package com.assignment.imdbmovie.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assignment.imdbmovie.data.model.TopMoviesItem

@Database(entities = [TopMoviesItem::class], version = 1, exportSchema = false)
abstract class IMDBDatabase : RoomDatabase() {
    abstract fun topMoviesDao(): TopMoviesDao
}