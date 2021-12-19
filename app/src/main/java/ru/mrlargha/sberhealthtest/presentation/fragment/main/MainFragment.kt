package ru.mrlargha.sberhealthtest.presentation.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.mrlargha.sberhealthtest.databinding.MainFragmentBinding
import ru.mrlargha.sberhealthtest.model.presentation.MainActivityState
import ru.mrlargha.sberhealthtest.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        private const val TAG = "MainFragment"
    }

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: MainFragmentBinding
    private val adapter = MedicineAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.mainFragmentRecyclerView.adapter = adapter
        subscribeUI()

        binding.mainFragmentRetryButton.setOnClickListener {
            viewModel.loadMedicines()
        }
        viewModel.loadMedicines()

        return binding.root
    }

    private fun subscribeUI() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is MainActivityState.Error -> {
                    binding.apply {
                        mainFragmentProgressBar.visibility = GONE
                        mainFragmentErrorText.visibility = VISIBLE
                        mainFragmentRetryButton.visibility = VISIBLE
                        mainFragmentRecyclerView.visibility = GONE
                        mainFragmentErrorText.text = it.errorText
                    }
                }
                MainActivityState.Loading -> {
                    binding.apply {
                        mainFragmentProgressBar.visibility = VISIBLE
                        mainFragmentErrorText.visibility = GONE
                        mainFragmentRetryButton.visibility = GONE
                        mainFragmentRecyclerView.visibility = GONE
                    }
                }
                is MainActivityState.MedicineListLoaded -> {
                    adapter.submitList(it.data)
                    binding.apply {
                        mainFragmentProgressBar.visibility = GONE
                        mainFragmentErrorText.visibility = GONE
                        mainFragmentRetryButton.visibility = GONE
                        mainFragmentRecyclerView.visibility = VISIBLE
                    }
                }
            }
        }
    }

}