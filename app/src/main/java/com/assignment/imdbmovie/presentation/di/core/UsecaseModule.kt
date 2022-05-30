package com.assignment.imdbmovie.presentation.di.core

import com.assignment.imdbmovie.domain.repository.TopMoviesRepository
import com.assignment.imdbmovie.domain.usecases.GetTopMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsecaseModule {

    @Singleton
    @Provides
    fun provideTopMoviesUseCase(topMoviesRepository: TopMoviesRepository): GetTopMoviesUseCase {
        return GetTopMoviesUseCase(topMoviesRepository)
    }
}