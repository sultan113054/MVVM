package com.assignment.imdbmovie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.imdbmovie.domain.usecases.GetTopMoviesUseCase

class TopMovieVieModelFactory(private val topMoviesUseCase: GetTopMoviesUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TopMoviesViewModel(topMoviesUseCase) as T
    }
}