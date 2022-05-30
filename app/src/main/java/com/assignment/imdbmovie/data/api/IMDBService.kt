package com.assignment.imdbmovie.data.api

import com.assignment.imdbmovie.data.model.TopMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IMDBService {

    @GET("Top250Movies/{api_key}")
    suspend fun getTopMovies(@Path(value = "api_key") apikey: String): Response<TopMovies>
}