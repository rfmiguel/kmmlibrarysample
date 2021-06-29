package br.com.fogaca.shared.di

import br.com.fogaca.shared.MoviesSdk
import br.com.fogaca.shared.network.MovieApi
import br.com.fogaca.shared.repository.MovieRepository
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.kodein.di.*
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val di = DI {

    bind<MoviesSdk>() with singleton { MoviesSdk() }

    bind<MovieApi>() with provider { MovieApi() }

    bind<MovieRepository>() with factory { movieApi: MovieApi -> MovieRepository(movieApi) }

    bind<HttpClient>() with provider {
        HttpClient {
            install(JsonFeature) {
                val json: Json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
    }
}
