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
import com.kortikoedu.kortiko.data.db.entities.CegahProgress
import com.kortikoedu.kortiko.databinding.FragmentCegahBinding
import com.kortikoedu.kortiko.ui.video.adapter.CegahAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CegahFragment : Fragment() {

    private val viewModel by viewModels<VideoViewModel>()
    private lateinit var binding: FragmentCegahBinding
    private lateinit var cegahAdapter: CegahAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCegahBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
        })

        ivDetail.setOnClickListener {
            findNavController().navigate(CegahFragmentDirections.actionCegahFragmentToAccountDialog())
        }

        cegahAdapter = CegahAdapter {
            when (it) {
                "1" -> {
                    lifecycleScope.launch {
                        viewModel.upsertCegahProgress(CegahProgress(0, "25%"))
                    }
                    findNavController().navigate(
                        CegahFragmentDirections.actionCegahFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=QiryvnU68hI"
                        )
                    )
                }
                "2" -> {
                    lifecycleScope.launch {
                        viewModel.upsertCegahProgress(CegahProgress(0, "50%"))
                    }
                    findNavController().navigate(
                        CegahFragmentDirections.actionCegahFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=g_H2Rvyoe7Q"
                        )
                    )
                }
                "3" -> {
                    lifecycleScope.launch {
                        viewModel.upsertCegahProgress(CegahProgress(0, "100%"))
                    }
                    findNavController().navigate(
                        CegahFragmentDirections.actionCegahFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=wEXG4BL_70E"
                        )
                    )
                }
            }
        }

        viewModel.getCegahProgress().observe(viewLifecycleOwner, {
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

        rvCegah.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = cegahAdapter
        }
    }

}