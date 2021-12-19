package ru.mrlargha.sberhealthtest.presentation.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.databinding.MainFragmentBinding
import ru.mrlargha.sberhealthtest.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        private const val TAG = "MainFragment"
    }

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container ,false)

        return binding.root
    }

}