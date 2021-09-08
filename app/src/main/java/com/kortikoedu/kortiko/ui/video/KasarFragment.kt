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
import com.kortikoedu.kortiko.data.db.entities.KasarProgress
import com.kortikoedu.kortiko.databinding.FragmentKasarBinding
import com.kortikoedu.kortiko.ui.video.adapter.KasarAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KasarFragment : Fragment() {

    private val viewModel by viewModels<VideoViewModel>()
    private lateinit var binding: FragmentKasarBinding
    private lateinit var kasarAdapter: KasarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKasarBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
        })

        ivDetail.setOnClickListener {
            findNavController().navigate(KasarFragmentDirections.actionKasarFragmentToAccountDialog())
        }

        kasarAdapter = KasarAdapter {
            when (it) {
                "1" -> {
                    lifecycleScope.launch {
                        viewModel.upsertKasarProgress(KasarProgress(0, "25%"))
                    }
                    findNavController().navigate(
                        KasarFragmentDirections.actionKasarFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=AbCeEzDviOY"
                        )
                    )
                }
                "2" -> {
                    lifecycleScope.launch {
                        viewModel.upsertKasarProgress(KasarProgress(0, "50%"))
                    }
                    findNavController().navigate(
                        KasarFragmentDirections.actionKasarFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=Nv0N23SM4tg"
                        )
                    )
                }
                "3" -> {
                    lifecycleScope.launch {
                        viewModel.upsertKasarProgress(KasarProgress(0, "75%"))
                    }
                    findNavController().navigate(
                        KasarFragmentDirections.actionKasarFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=gtRuHXKuCrA"
                        )
                    )
                }
                "4" -> {
                    lifecycleScope.launch {
                        viewModel.upsertKasarProgress(KasarProgress(0, "100%"))
                    }
                    findNavController().navigate(
                        KasarFragmentDirections.actionKasarFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=MG1_99rzkjY"
                        )
                    )
                }
            }
        }

        viewModel.getKasarProgress().observe(viewLifecycleOwner, {
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
                it.progress == "75%" -> {
                    progressBar.progress = 75
                    txtProgress.text = it.progress
                }
                it.progress == "100%" -> {
                    progressBar.progress = 100
                    txtProgress.text = it.progress
                }
            }
        })

        rvKasar.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = kasarAdapter
        }
    }

}