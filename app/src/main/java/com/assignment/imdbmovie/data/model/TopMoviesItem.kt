package com.assignment.imdbmovie.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "top_movies_item")
data class TopMoviesItem(
    @SerializedName("crew")
    var crew: String,
    @SerializedName("fullTitle")
    var fullTitle: String,
    @PrimaryKey
    @SerializedName("id")
    var id: String,
    @SerializedName("imDbRating")
    var imDbRating: String,
    @SerializedName("imDbRatingCount")
    var imDbRatingCount: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("rank")
    var rank: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("year")
    var year: String
)