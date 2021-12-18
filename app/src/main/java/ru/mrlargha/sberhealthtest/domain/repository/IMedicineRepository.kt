package ru.mrlargha.sberhealthtest.domain.repository

import ru.mrlargha.sberhealthtest.model.Medicine
import ru.mrlargha.sberhealthtest.model.ServerResponse

interface IMedicineRepository {
    suspend fun getAllMedicines(): ServerResponse<List<Medicine>>
}