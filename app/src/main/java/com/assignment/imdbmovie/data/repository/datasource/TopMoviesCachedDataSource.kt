package com.assignment.imdbmovie.data.repository.datasource

import com.assignment.imdbmovie.data.model.TopMoviesItem

interface TopMoviesCachedDataSource {
    suspend fun getTopMoviesFromCache():List<TopMoviesItem>
    suspend fun saveTopMoviesToCache(topMovies:List<TopMoviesItem>)
}