package br.com.fogaca.shared.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movies(
    val page: Int,
    val results: List<Movie>
)

@Serializable
data class Movie(
    @SerialName("id")
    val id: Int,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("original_title")
    val originalTitle: String,
    @SerialName("genre_ids")
    val genres: List<Int>,
    @SerialName("overview")
    val overview: String
)