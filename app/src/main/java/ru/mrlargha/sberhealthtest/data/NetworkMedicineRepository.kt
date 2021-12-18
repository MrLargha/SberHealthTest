package ru.mrlargha.sberhealthtest.data

import ru.mrlargha.sberhealthtest.domain.repository.IMedicineRepository
import ru.mrlargha.sberhealthtest.model.Medicine
import ru.mrlargha.sberhealthtest.model.ServerResponse
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class NetworkMedicineRepository @Inject constructor(private val medicineAPI: MedicineAPI) :
    IMedicineRepository {
    override suspend fun getAllMedicines(): ServerResponse<List<Medicine>> {
        return try {
            val result = medicineAPI.getAllMedicines()
            if (result.isSuccessful && result.body() != null) {
                ServerResponse.SuccessfulResponse(result.body())
            } else {
                throw IOException("Response is not successful. Code:${result.code()}")
            }
        } catch (e: Exception) {
            ServerResponse.ResponseError(null, e)
        }
    }
}