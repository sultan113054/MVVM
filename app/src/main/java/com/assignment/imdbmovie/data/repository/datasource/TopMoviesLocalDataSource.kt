package com.assignment.imdbmovie.data.repository.datasource

import com.assignment.imdbmovie.data.model.TopMoviesItem

interface TopMoviesLocalDataSource {
    suspend fun getTopMoviesFromDB():List<TopMoviesItem>
    suspend fun saveTopMoviesToDB(topMovies:List<TopMoviesItem>)
}