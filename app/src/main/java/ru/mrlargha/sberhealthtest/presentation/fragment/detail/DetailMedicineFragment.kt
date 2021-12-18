package ru.mrlargha.sberhealthtest.presentation.fragment.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.presentation.viewmodel.DetailMedicineFragmentViewModel

class DetailMedicineFragment : Fragment() {

    companion object {
        fun newInstance() = DetailMedicineFragment()
    }

    private lateinit var viewModel: DetailMedicineFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_medicine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMedicineFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}