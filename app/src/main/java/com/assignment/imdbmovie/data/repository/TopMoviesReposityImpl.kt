package com.assignment.imdbmovie.data.repository

import android.util.Log
import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesCachedDataSource
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesLocalDataSource
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesRemoteDataSource
import com.assignment.imdbmovie.domain.repository.TopMoviesRepository
import java.lang.Exception

class TopMoviesReposityImpl(
    private val topMoviesRemoteDataSource: TopMoviesRemoteDataSource,
    private val topMoviesLocalDataSource: TopMoviesLocalDataSource,
    private val topMoviesCachedDataSource: TopMoviesCachedDataSource
) : TopMoviesRepository {
    override suspend fun getTopMovies(): List<TopMoviesItem>? {
        return getTopMoviesFromCache()
    }

    suspend fun getTopMoviesFromApi(): List<TopMoviesItem> {

        lateinit var movies: List<TopMoviesItem>
        try {
            val response = topMoviesRemoteDataSource.getTopMoviesFromServer()
            val body = response?.body()
            body?.let {
                movies = body.items!!
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.toString())
        }
        return movies


    }

    suspend fun getTopMoviesFromLocalDb(): List<TopMoviesItem> {
        lateinit var movies: List<TopMoviesItem>
        try {
            movies = topMoviesLocalDataSource.getTopMoviesFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", e.toString())
        }
        if (movies.size > 0)
            return movies
        else {
            movies = getTopMoviesFromApi()
            topMoviesLocalDataSource.saveTopMoviesToDB(movies)
        }
        return movies
    }

    suspend fun getTopMoviesFromCache(): List<TopMoviesItem> {
        lateinit var movies: List<TopMoviesItem>
        try {
            movies = topMoviesCachedDataSource.getTopMoviesFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.toString())
        }
        if (movies.size > 0)
            return movies
        else {
            movies = getTopMoviesFromLocalDb()
            topMoviesCachedDataSource.saveTopMoviesToCache(movies)
        }
        return movies
    }
}