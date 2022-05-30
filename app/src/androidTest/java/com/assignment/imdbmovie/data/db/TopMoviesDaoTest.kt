package com.assignment.imdbmovie.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TopMoviesDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var subscriberDao: TopMoviesDao
    private lateinit var subscriberDatabase: IMDBDatabase

    @Before
    fun setUp() {
        subscriberDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            IMDBDatabase::class.java
        ).build()

        subscriberDao = subscriberDatabase.topMoviesDao()
    }

    @Test
    fun insertSubscribersTest() {
        runBlocking {
            val list = listOf(
                TopMoviesItem(
                    "name1",
                    "a",
                    "1223",
                    "name1.gmail",
                    "name1.gmail",
                    "name1.gmail",
                    "name1.gmail",
                    "name1.gmail",
                    "name1.gmail"
                ),
            )
            subscriberDao.saveTopMovies(list)
            val subscribers = subscriberDao.getTopMovies()
            Truth.assertThat(subscribers).isEqualTo(list)
        }
    }

    @After
    fun tearDown() {
        subscriberDatabase.close()
    }
}