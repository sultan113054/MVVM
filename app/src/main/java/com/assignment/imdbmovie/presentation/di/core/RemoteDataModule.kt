package com.assignment.imdbmovie.presentation.di.core

import com.assignment.imdbmovie.data.api.IMDBService
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesCachedDataSource
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesRemoteDataSource
import com.assignment.imdbmovie.data.repository.datasourceimpl.TopMoviesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideTopMoviesRemoteDataSource(imdbService: IMDBService): TopMoviesRemoteDataSource {
        return TopMoviesRemoteDataSourceImpl(imdbService, apiKey)
    }
}