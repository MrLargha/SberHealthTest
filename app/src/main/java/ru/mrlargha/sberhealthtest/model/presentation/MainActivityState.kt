package ru.mrlargha.sberhealthtest.model.presentation

import ru.mrlargha.sberhealthtest.model.Medicine

sealed class MainActivityState {
    object Loading : MainActivityState()
    data class Error(val errorText: String): MainActivityState()
    data class MedicineListLoaded(val data: List<Medicine>): MainActivityState()
}
