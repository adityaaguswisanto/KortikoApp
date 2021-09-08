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
import com.kortikoedu.kortiko.data.db.entities.HalusProgress
import com.kortikoedu.kortiko.databinding.FragmentHalusBinding
import com.kortikoedu.kortiko.ui.video.adapter.HalusAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HalusFragment : Fragment() {

    private val viewModel by viewModels<VideoViewModel>()
    private lateinit var binding: FragmentHalusBinding
    private lateinit var halusAdapter: HalusAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHalusBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
        })

        ivDetail.setOnClickListener {
            findNavController().navigate(HalusFragmentDirections.actionHalusFragmentToAccountDialog())
        }

        halusAdapter = HalusAdapter {
            when (it) {
                "1" -> {
                    lifecycleScope.launch {
                        viewModel.upsertHalusProgress(HalusProgress(0, "50%"))
                    }
                    findNavController().navigate(
                        HalusFragmentDirections.actionHalusFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=5Duvi2rAFwg"
                        )
                    )
                }
                "2" -> {
                    lifecycleScope.launch {
                        viewModel.upsertHalusProgress(HalusProgress(0, "100%"))
                    }
                    findNavController().navigate(
                        HalusFragmentDirections.actionHalusFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=k7K2I5GhxtY"
                        )
                    )
                }
            }
        }

        viewModel.getHalusProgress().observe(viewLifecycleOwner, {
            when {
                it == null -> {
                    txtProgress.text = "0%"
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

        rvHalus.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = halusAdapter
        }
    }

}