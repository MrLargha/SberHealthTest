package ru.mrlargha.sberhealthtest.presentation.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.databinding.DetailMedicineFragmentBinding
import ru.mrlargha.sberhealthtest.presentation.viewmodel.MainViewModel
import java.lang.IllegalStateException

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

    private lateinit var binding: DetailMedicineFragmentBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailMedicineFragmentBinding.inflate(inflater, container, false)
        requireArguments().getString(TITLE_TAG, null)
            ?.let { binding.detailMedicineFragmentToolbar.title = it }
            ?: throw IllegalStateException("Title must be passed as argument")
        binding.detailMedicineFragmentToolbar.setNavigationOnClickListener {
            viewModel.unselectMedicine()
        }
        return binding.root
    }
}