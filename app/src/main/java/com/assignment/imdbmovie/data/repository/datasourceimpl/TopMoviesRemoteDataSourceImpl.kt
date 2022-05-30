package com.assignment.imdbmovie.data.repository.datasourceimpl

import com.assignment.imdbmovie.data.api.IMDBService
import com.assignment.imdbmovie.data.model.TopMovies
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesRemoteDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Response
import javax.inject.Singleton

@Module
class TopMoviesRemoteDataSourceImpl(private val imdbService: IMDBService,private val apiKey:String):
    TopMoviesRemoteDataSource {
    @Singleton
    @Provides
    override suspend fun getTopMoviesFromServer(): Response<TopMovies>? {
        return imdbService.getTopMovies(apiKey)
    }
}