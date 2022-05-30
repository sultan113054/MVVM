package com.assignment.imdbmovie.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.domain.usecases.GetTopMoviesUseCase

class TopMoviesViewModel(
    private val getTopMoviesUseCase: GetTopMoviesUseCase
) : ViewModel() {
    fun getTopMovies() =
        liveData {
            val movies = getTopMoviesUseCase.execute()
            emit(movies)
        }


}