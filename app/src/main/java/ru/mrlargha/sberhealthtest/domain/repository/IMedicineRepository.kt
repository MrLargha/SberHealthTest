package ru.mrlargha.sberhealthtest.domain.repository

import ru.mrlargha.sberhealthtest.model.Medicine
import ru.mrlargha.sberhealthtest.model.ServerResponse

/**
 * Репозитория для работы с медикаментами
 *
 */
interface IMedicineRepository {
    /**
     * Получить список всех медикаментов
     *
     * @return [ServerResponse.SuccessfulResponse] в случае успеха или [ServerResponse.ResponseError] если возникли ошибки
     */
    suspend fun getAllMedicines(): ServerResponse<List<Medicine>>
}