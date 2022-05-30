package com.assignment.imdbmovie.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.assignment.imdbmovie.data.model.TopMovies
import com.assignment.imdbmovie.data.model.TopMoviesItem

@Dao
interface TopMoviesDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTopMovies(topMovies:List<TopMoviesItem>)

    @Query("Select * from top_movies_item")
    suspend fun getTopMovies():List<TopMoviesItem>
}