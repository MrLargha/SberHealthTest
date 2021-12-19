package ru.mrlargha.sberhealthtest.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import dagger.hilt.android.AndroidEntryPoint
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.databinding.ActivityMainBinding
import ru.mrlargha.sberhealthtest.model.presentation.MainActivityState
import ru.mrlargha.sberhealthtest.presentation.fragment.detail.DetailMedicineFragment
import ru.mrlargha.sberhealthtest.presentation.fragment.main.MainFragment
import ru.mrlargha.sberhealthtest.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeUI()

        supportFragmentManager.commit {
            replace<MainFragment>(R.id.activity_main_fragment_container)
        }

    }

    private fun subscribeUI() {
        viewModel.selectedMedicine.observe(this) {
            if (it == null) {
                supportFragmentManager.popBackStack()
            } else {
                supportFragmentManager.commit {
                    replace<DetailMedicineFragment>(
                        R.id.activity_main_fragment_container,
                        null,
                        DetailMedicineFragment.newBundle(it.title)
                    )
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }
    }

    override fun onBackPressed() {
        viewModel.unselectMedicine()
    }
}