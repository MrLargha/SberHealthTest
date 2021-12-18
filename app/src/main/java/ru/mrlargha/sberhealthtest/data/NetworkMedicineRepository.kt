package ru.mrlargha.sberhealthtest.data

import ru.mrlargha.sberhealthtest.domain.repository.IMedicineRepository
import ru.mrlargha.sberhealthtest.model.Medicine
import ru.mrlargha.sberhealthtest.model.ServerResponse

class NetworkMedicineRepository : IMedicineRepository {
    override suspend fun getAllMedicines(): ServerResponse<List<Medicine>> {
        TODO("Not yet implemented")
    }
}