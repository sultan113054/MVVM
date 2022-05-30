package com.assignment.imdbmovie.data.repository

import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.domain.repository.TopMoviesRepository


class FakeTopMoviesReposity : TopMoviesRepository {
    private var movies = mutableListOf<TopMoviesItem>()

    init {
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
                "name1.gmail"
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
                "name1.gmail"
            ),
        )
    }

    override suspend fun getTopMovies(): List<TopMoviesItem> {
        return movies
    }

}