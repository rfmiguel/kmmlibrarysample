package br.com.fogaca.shared.repository

import br.com.fogaca.shared.data.Response
import br.com.fogaca.shared.domain.Movies
import br.com.fogaca.shared.network.MovieApi

class MovieRepository(private val movieApi: MovieApi) {

    suspend fun getPopularMovies(): Response<Movies> = movieApi.getMovies()
}