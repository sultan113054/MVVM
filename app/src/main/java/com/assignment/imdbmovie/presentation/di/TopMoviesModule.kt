package com.assignment.imdbmovie.presentation.di

import com.assignment.imdbmovie.domain.usecases.GetTopMoviesUseCase
import com.assignment.imdbmovie.presentation.TopMovieVieModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TopMoviesModule {

    @TopMoviesScope
    @Provides
    fun provideTopMoviesViwModelFactory(topMoviesUseCase: GetTopMoviesUseCase): TopMovieVieModelFactory {
        return TopMovieVieModelFactory(topMoviesUseCase)
    }
}