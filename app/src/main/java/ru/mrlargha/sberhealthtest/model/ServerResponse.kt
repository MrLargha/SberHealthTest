package ru.mrlargha.sberhealthtest.model

import java.lang.Exception

sealed class ServerResponse<out T> {
    data class SuccessfulResponse<T>(val data: T) : ServerResponse<T>()
    data class ResponseError<T>(val data: T?, val exception: Exception) : ServerResponse<T>()
}
