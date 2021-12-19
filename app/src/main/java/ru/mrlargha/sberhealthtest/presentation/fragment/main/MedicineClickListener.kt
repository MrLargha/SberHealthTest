package ru.mrlargha.sberhealthtest.presentation.fragment.main

import ru.mrlargha.sberhealthtest.model.Medicine

/**
 * Слушатель клика по лекарству
 *
 */
fun interface MedicineClickListener {
    /**
     * Совершён клик по медикаменту
     *
     * @param medicine кликнуты медикамент
     */
    fun onMedicineClick(medicine: Medicine)
}