package ru.mrlargha.sberhealthtest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.mrlargha.sberhealthtest.domain.repository.IMedicineRepository
import ru.mrlargha.sberhealthtest.model.Medicine
import ru.mrlargha.sberhealthtest.model.ServerResponse
import ru.mrlargha.sberhealthtest.model.presentation.MainActivityState
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val medicineRepository: IMedicineRepository) :
    ViewModel() {

    companion object {
        private const val TAG = "MainActivityViewModel"
    }

    private val _viewState: MutableLiveData<MainActivityState> =
        MutableLiveData(MainActivityState.Loading)

    private val _selectedMedicine: MutableLiveData<Medicine?> = MutableLiveData(null)

    val viewState: LiveData<MainActivityState> = _viewState

    val selectedMedicine: LiveData<Medicine?> = _selectedMedicine


    fun loadMedicines() {
        viewModelScope.launch {
            when (val response = medicineRepository.getAllMedicines()) {
                is ServerResponse.SuccessfulResponse -> {
                    Log.d(TAG, "loadMedicines: ${response.data}")
                }
                is ServerResponse.ResponseError -> {
                    Log.d(TAG, "loadMedicines: ${response.exception}")
                }
            }
        }
    }

    fun selectMedicine(medicine: Medicine) {
        _selectedMedicine.value = medicine
    }

    fun unselectMedicine() {
        _selectedMedicine.value = null
    }

}