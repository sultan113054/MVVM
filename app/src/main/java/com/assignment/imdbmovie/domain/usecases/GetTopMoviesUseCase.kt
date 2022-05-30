package com.assignment.imdbmovie.domain.usecases

import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.domain.repository.TopMoviesRepository

class GetTopMoviesUseCase(private val topMoviesRepository: TopMoviesRepository) {

    suspend fun execute(): List<TopMoviesItem>? = topMoviesRepository.getTopMovies()
}