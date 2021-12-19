package ru.mrlargha.sberhealthtest.presentation.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class DetailMedicineFragment : Fragment() {

    companion object {
        private const val TITLE_TAG = "TITLE"

        fun newBundle(title: String): Bundle {
            val bundle = Bundle()
            bundle.putString(TITLE_TAG, title)
            return bundle
        }
    }

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_medicine_fragment, container, false)
    }
}