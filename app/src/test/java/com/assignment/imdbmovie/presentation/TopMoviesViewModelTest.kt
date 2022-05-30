package com.assignment.imdbmovie.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anushka.tmdbclient.getOrAwaitValue
import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.data.repository.FakeTopMoviesReposity
import com.assignment.imdbmovie.domain.usecases.GetTopMoviesUseCase
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TopMoviesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var topMoviesViewModel: TopMoviesViewModel

    @Before
    fun setUp() {
        val fakeTopMoviesReposity = FakeTopMoviesReposity()
        val getTopMoviesUseCase = GetTopMoviesUseCase(fakeTopMoviesReposity)
        topMoviesViewModel = TopMoviesViewModel(getTopMoviesUseCase)
    }

    @Test
    fun getTopMovies_returnCurrentList() {
        var movies = mutableListOf<TopMoviesItem>()
        movies.add(
            TopMoviesItem(
                "name1",
                "a",
                "1223",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
            ),
        )
        movies.add(
            TopMoviesItem(
                "name1",
                "a",
                "122344",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
                "name1.gmail",
            ),
        )

        var movoieList = topMoviesViewModel.getTopMovies().getOrAwaitValue()
        Truth.assertThat(movoieList).isEqualTo(movies)
    }
}