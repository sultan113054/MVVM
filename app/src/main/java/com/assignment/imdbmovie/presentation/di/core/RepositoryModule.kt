package com.assignment.imdbmovie.presentation.di.core

import com.assignment.imdbmovie.data.repository.TopMoviesReposityImpl
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesCachedDataSource
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesLocalDataSource
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesRemoteDataSource
import com.assignment.imdbmovie.domain.repository.TopMoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTopMoviesRepository(
        topMoviesRemoteDataSource: TopMoviesRemoteDataSource,
        topMoviesLocalDataSource: TopMoviesLocalDataSource,
        topMoviesCachedDataSource: TopMoviesCachedDataSource
    ): TopMoviesRepository {
        return TopMoviesReposityImpl(
            topMoviesRemoteDataSource,
            topMoviesLocalDataSource,
            topMoviesCachedDataSource
        )
    }
}