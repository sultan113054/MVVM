package com.assignment.imdbmovie.domain.repository

import com.assignment.imdbmovie.data.model.TopMoviesItem

interface TopMoviesRepository {
    suspend fun getTopMovies():List<TopMoviesItem>?
}