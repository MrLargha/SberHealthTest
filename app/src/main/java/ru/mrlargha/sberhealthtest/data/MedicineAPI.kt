package ru.mrlargha.sberhealthtest.data

import retrofit2.Response
import retrofit2.http.GET
import ru.mrlargha.sberhealthtest.model.Medicine

/**
 * Retrofit API для получения медикаментов
 *
 */
interface MedicineAPI {
    @GET("/v3/b168786f-720f-4f30-8fba-a0345d49823a")
    suspend fun getAllMedicines(): Response<List<Medicine>>
}