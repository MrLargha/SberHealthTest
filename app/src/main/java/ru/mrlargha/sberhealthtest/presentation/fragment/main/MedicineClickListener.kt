package ru.mrlargha.sberhealthtest.presentation.fragment.main

import ru.mrlargha.sberhealthtest.model.Medicine

fun interface MedicineClickListener {
    fun onMedicineClick(medicine: Medicine)
}