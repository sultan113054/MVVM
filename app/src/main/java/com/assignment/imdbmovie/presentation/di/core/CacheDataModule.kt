package com.assignment.imdbmovie.presentation.di.core

import com.assignment.imdbmovie.data.repository.datasource.TopMoviesCachedDataSource
import com.assignment.imdbmovie.data.repository.datasourceimpl.TopMoviesCachedDataSourceImple
import com.assignment.imdbmovie.data.repository.datasourceimpl.TopMoviesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideTopMoviesCacheDataSource():TopMoviesCachedDataSource{
        return TopMoviesCachedDataSourceImple()
    }
}
