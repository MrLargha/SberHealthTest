package ru.mrlargha.sberhealthtest.model

import java.lang.Exception

/**
 * Ответ сервера
 *
 * @param T моделька, которую мы ожидаем
 */
sealed class ServerResponse<out T> {
    /**
     * Успешный ответ
     *
     * @param T тип модельки, которую мы запросили
     * @property data сама моделька типа [T]
     */
    data class SuccessfulResponse<T>(val data: T) : ServerResponse<T>()

    /**
     * Ошибка
     *
     * @param T тип данных об ошибке (вдруг понабится что-то ещё протащить)
     * @property data данные об ошибке
     * @property exception
     */
    data class ResponseError<T>(val data: T?, val exception: Exception) : ServerResponse<T>()
}
