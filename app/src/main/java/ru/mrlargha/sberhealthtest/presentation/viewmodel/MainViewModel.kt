package ru.mrlargha.sberhealthtest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.mrlargha.sberhealthtest.domain.repository.IMedicineRepository
import ru.mrlargha.sberhealthtest.model.Medicine
import ru.mrlargha.sberhealthtest.model.ServerResponse
import ru.mrlargha.sberhealthtest.model.presentation.MainActivityState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val medicineRepository: IMedicineRepository) :
    ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    private val _viewState: MutableLiveData<MainActivityState> =
        MutableLiveData(MainActivityState.Loading)

    private val _selectedMedicine: MutableLiveData<Medicine?> = MutableLiveData(null)

    private var job: Job? = null

    val viewState: LiveData<MainActivityState> = _viewState

    val selectedMedicine: LiveData<Medicine?> = _selectedMedicine

    init {
        Log.v(TAG, "ViewModel created")
    }

    fun loadMedicines() {
        Log.d(TAG, "loadMedicines: requested medicines load")
        job = viewModelScope.launch {
            val currentViewState = viewState.value as? MainActivityState.MedicineListLoaded
            if (currentViewState != null && currentViewState.data.isNotEmpty()) {
                Log.d(TAG, "loadMedicines: medicines loaded, nothing to load")
                return@launch
            }
            when (val response = medicineRepository.getAllMedicines()) {
                is ServerResponse.SuccessfulResponse -> {
                    Log.i(TAG, "loadMedicines: ${response.data}")
                    _viewState.postValue(MainActivityState.MedicineListLoaded(response.data))
                }
                is ServerResponse.ResponseError -> {
                    Log.w(TAG, "loadMedicines: ${response.exception}")
                    _viewState.postValue(MainActivityState.Error("При загрузке произошла ошибка"))
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

    override fun onCleared() {
        job?.cancel()
        Log.v(TAG, "onCleared: viewModel cleared")
        super.onCleared()
    }
}