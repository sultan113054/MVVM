package com.assignment.imdbmovie.data.repository.datasource

import com.assignment.imdbmovie.data.model.TopMovies
import com.assignment.imdbmovie.data.model.TopMoviesItem
import retrofit2.Response

interface TopMoviesRemoteDataSource {
    suspend fun getTopMoviesFromServer():Response<TopMovies>?
}