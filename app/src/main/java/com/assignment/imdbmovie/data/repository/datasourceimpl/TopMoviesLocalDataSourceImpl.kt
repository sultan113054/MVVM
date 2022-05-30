package com.assignment.imdbmovie.data.repository.datasourceimpl

import com.assignment.imdbmovie.data.db.TopMoviesDao
import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.data.repository.datasource.TopMoviesLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopMoviesLocalDataSourceImpl(private val topMoviesDao: TopMoviesDao) :
    TopMoviesLocalDataSource {
    override suspend fun getTopMoviesFromDB(): List<TopMoviesItem> {
        return topMoviesDao.getTopMovies()
    }

    override suspend fun saveTopMoviesToDB(topMovies: List<TopMoviesItem>) {
        CoroutineScope(Dispatchers.IO).launch {
            topMoviesDao.saveTopMovies(topMovies)
        }
    }
}