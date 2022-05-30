package com.assignment.imdbmovie.data.repository.datasourceimpl

import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesCachedDataSource

class TopMoviesCachedDataSourceImple : TopMoviesCachedDataSource {
    private var movies = ArrayList<TopMoviesItem>()
    override suspend fun getTopMoviesFromCache(): List<TopMoviesItem> {
        return movies
    }

    override suspend fun saveTopMoviesToCache(topMovies: List<TopMoviesItem>) {
        movies.clear()
        movies = ArrayList(topMovies)
    }


}