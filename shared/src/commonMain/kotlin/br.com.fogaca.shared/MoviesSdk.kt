package br.com.fogaca.shared

import br.com.fogaca.shared.repository.MovieRepository
import br.com.fogaca.shared.data.Response
import br.com.fogaca.shared.di.di
import br.com.fogaca.shared.domain.Movies
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.kodein.di.instance
import org.kodein.di.newInstance

class MoviesSdk {

    private val movieRepository by di.newInstance { MovieRepository(instance()) }
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    suspend fun getPopularMovies(): Response<Movies> = withContext(dispatcher) {
        movieRepository.getPopularMovies()
    }
}