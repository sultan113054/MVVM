package com.assignment.imdbmovie.data.model


import com.google.gson.annotations.SerializedName

data class TopMovies(
    @SerializedName("errorMessage")
    var errorMessage: String,
    @SerializedName("items")
    var items: List<TopMoviesItem>?
)