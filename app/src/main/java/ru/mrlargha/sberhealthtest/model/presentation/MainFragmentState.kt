package ru.mrlargha.sberhealthtest.model.presentation

import ru.mrlargha.sberhealthtest.model.Medicine

/**
 * Состояние главной активность
 *
 */
sealed class MainFragmentState {
    /**
     * Идёт загрузка данных
     */
    object Loading : MainFragmentState()

    /**
     * Загрузка данных завешилась с ошибкой
     *
     * @property errorText
     */
    data class Error(val errorText: String) : MainFragmentState()

    /**
     * Загрузка данных успешна
     *
     * @property data
     */
    data class MedicineListLoaded(val data: List<Medicine>) : MainFragmentState()
}
