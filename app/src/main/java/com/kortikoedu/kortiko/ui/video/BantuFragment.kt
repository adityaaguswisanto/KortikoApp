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
import com.kortikoedu.kortiko.data.db.entities.BantuProgress
import com.kortikoedu.kortiko.databinding.FragmentBantuBinding
import com.kortikoedu.kortiko.ui.video.adapter.BantuAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BantuFragment : Fragment() {

    private val viewModel by viewModels<VideoViewModel>()
    private lateinit var binding: FragmentBantuBinding
    private lateinit var bantuAdapter: BantuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBantuBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
        })

        ivDetail.setOnClickListener {
            findNavController().navigate(BantuFragmentDirections.actionBantuFragmentToAccountDialog())
        }

        bantuAdapter = BantuAdapter {
            when (it) {
                "1" -> {
                    lifecycleScope.launch {
                        viewModel.upsertBantuProgress(BantuProgress(0, "15%"))
                    }
                    findNavController().navigate(
                        BantuFragmentDirections.actionBantuFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=c8YKJ0GRCAI"
                        )
                    )
                }
                "2" -> {
                    lifecycleScope.launch {
                        viewModel.upsertBantuProgress(BantuProgress(0, "25%"))
                    }
                    findNavController().navigate(
                        BantuFragmentDirections.actionBantuFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=uNgeqP0zNOU"
                        )
                    )
                }
                "3" -> {
                    lifecycleScope.launch {
                        viewModel.upsertBantuProgress(BantuProgress(0, "50%"))
                    }
                    findNavController().navigate(
                        BantuFragmentDirections.actionBantuFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=MIWfovcs9B4"
                        )
                    )
                }
                "4" -> {
                    lifecycleScope.launch {
                        viewModel.upsertBantuProgress(BantuProgress(0, "65%"))
                    }
                    findNavController().navigate(
                        BantuFragmentDirections.actionBantuFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=Vdg6cn77Z_w"
                        )
                    )
                }
                "5" -> {
                    lifecycleScope.launch {
                        viewModel.upsertBantuProgress(BantuProgress(0, "75%"))
                    }
                    findNavController().navigate(
                        BantuFragmentDirections.actionBantuFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=GJeZv0ILS2Y"
                        )
                    )
                }
                "6" -> {
                    lifecycleScope.launch {
                        viewModel.upsertBantuProgress(BantuProgress(0, "100%"))
                    }
                    findNavController().navigate(
                        BantuFragmentDirections.actionBantuFragmentToPlayerFragment(
                            "https://www.youtube.com/watch?v=j6jMb8fpbac"
                        )
                    )
                }
            }
        }

        viewModel.getBantuProgress().observe(viewLifecycleOwner, {
            when {
                it == null -> {
                    txtProgress.text = "0%"
                }
                it.progress == "15%" -> {
                    progressBar.progress = 15
                    txtProgress.text = it.progress
                }
                it.progress == "25%" -> {
                    progressBar.progress = 25
                    txtProgress.text = it.progress
                }
                it.progress == "50%" -> {
                    progressBar.progress = 50
                    txtProgress.text = it.progress
                }
                it.progress == "65%" -> {
                    progressBar.progress = 65
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

        rvBantu.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = bantuAdapter
        }
    }

}