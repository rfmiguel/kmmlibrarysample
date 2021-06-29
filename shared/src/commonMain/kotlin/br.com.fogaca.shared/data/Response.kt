package br.com.fogaca.shared.data

sealed class Response<out T> {
    class Success<out T>(val data: T) : Response<T>()
    data class Error(val exception: Throwable) : Response<Nothing>()
}