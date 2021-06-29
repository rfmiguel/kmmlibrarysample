package br.com.fogaca.shared.network

import br.com.fogaca.shared.data.Response
import br.com.fogaca.shared.di.di
import io.ktor.client.*
import io.ktor.client.request.*
import org.kodein.di.instance

suspend inline fun <reified T> call(url:String) : Response<T> {
    return try {
        val httpClient: HttpClient by di.instance()
        val response: T = httpClient.get(urlString = url)
        Response.Success(response)
    } catch(ex: Exception) {
        Response.Error(ex)
    }
}
