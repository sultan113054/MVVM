package com.assignment.imdbmovie.presentation.di.core

import com.assignment.imdbmovie.data.db.TopMoviesDao
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesLocalDataSource
import com.assignment.imdbmovie.data.repository.datasourceimpl.TopMoviesLocalDataSourceImpl
import com.assignment.imdbmovie.data.repository.datasourceimpl.TopMoviesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideTopMoviesLocalDataSource(topMoviesDao: TopMoviesDao): TopMoviesLocalDataSource {
        return TopMoviesLocalDataSourceImpl(topMoviesDao)
    }

}