package com.kortikoedu.kortiko.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kortikoedu.kortiko.data.db.entities.MotorProgress
import com.kortikoedu.kortiko.databinding.FragmentMotorBinding
import com.kortikoedu.kortiko.ui.video.adapter.MotorAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MotorFragment : Fragment() {

    private val viewModel by viewModels<VideoViewModel>()
    private lateinit var binding: FragmentMotorBinding
    private lateinit var motorAdapter: MotorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMotorBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
        })

        ivDetail.setOnClickListener {
            findNavController().navigate(MotorFragmentDirections.actionMotorFragmentToAccountDialog())
        }

        motorAdapter = MotorAdapter {
            when (it) {
                "1" -> {
                    lifecycleScope.launch {
                        viewModel.upsertMotorProgress(MotorProgress(0, "25%"))
                    }
                    findNavController().navigate(
                        MotorFragmentDirections.actionMotorFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=b1DWASiE180"
                        )
                    )
                }
                "2" -> {
                    lifecycleScope.launch {
                        viewModel.upsertMotorProgress(MotorProgress(0, "50%"))
                    }
                    findNavController().navigate(
                        MotorFragmentDirections.actionMotorFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=c_-kByHSEMk"
                        )
                    )
                }
                "3" -> {
                    lifecycleScope.launch {
                        viewModel.upsertMotorProgress(MotorProgress(0, "100%"))
                    }
                    findNavController().navigate(
                        MotorFragmentDirections.actionMotorFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=IE54sEfQWJI"
                        )
                    )
                }
            }
        }

        viewModel.getMotorProgress().observe(viewLifecycleOwner, {
            when {
                it == null -> {
                    txtProgress.text = "0%"
                }
                it.progress == "25%" -> {
                    progressBar.progress = 25
                    txtProgress.text = it.progress
                }
                it.progress == "50%" -> {
                    progressBar.progress = 50
                    txtProgress.text = it.progress
                }
                it.progress == "100%" -> {
                    progressBar.progress = 100
                    txtProgress.text = it.progress
                }
            }
        })

        rvMotor.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = motorAdapter
        }
    }

}