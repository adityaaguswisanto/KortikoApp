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
import com.kortikoedu.kortiko.data.db.entities.UmumProgress
import com.kortikoedu.kortiko.databinding.FragmentUmumBinding
import com.kortikoedu.kortiko.ui.video.adapter.UmumAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UmumFragment : Fragment() {

    private val viewModel by viewModels<VideoViewModel>()
    private lateinit var binding: FragmentUmumBinding
    private lateinit var umumAdapter: UmumAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUmumBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {

        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
        })

        ivDetail.setOnClickListener {
            findNavController().navigate(UmumFragmentDirections.actionUmumFragmentToAccountDialog())
        }

        umumAdapter = UmumAdapter {
            when (it) {
                "1" -> {
                    lifecycleScope.launch {
                        viewModel.upsertUmumProgress(UmumProgress(0, "25%"))
                    }
                    findNavController().navigate(
                        UmumFragmentDirections.actionUmumFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=6aoR9gs_t4s"
                        )
                    )
                }
                "2" -> {
                    lifecycleScope.launch {
                        viewModel.upsertUmumProgress(UmumProgress(0, "50%"))
                    }
                    findNavController().navigate(
                        UmumFragmentDirections.actionUmumFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=p1NAmqdVn7M"
                        )
                    )
                }
                "3" -> {
                    lifecycleScope.launch {
                        viewModel.upsertUmumProgress(UmumProgress(0, "75%"))
                    }
                    findNavController().navigate(
                        UmumFragmentDirections.actionUmumFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=gWPj4M9JknM"
                        )
                    )
                }
                "4" -> {
                    lifecycleScope.launch {
                        viewModel.upsertUmumProgress(UmumProgress(0, "100%"))
                    }
                    findNavController().navigate(
                        UmumFragmentDirections.actionUmumFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=QWg8ABHGcSQ"
                        )
                    )
                }
            }
        }

        viewModel.getUmumProgress().observe(viewLifecycleOwner, {
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

        rvUmum.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = umumAdapter
        }
    }

}