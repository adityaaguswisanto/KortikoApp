package com.kortikoedu.kortiko.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.kortikoedu.kortiko.databinding.FragmentMainBinding
import com.kortikoedu.kortiko.ui.main.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        mainAdapter = MainAdapter {
            when (it) {
                "1" -> {
                    findNavController().navigate(MainFragmentDirections.actionMainFragmentToUmumFragment())
                }
                "2" -> {
                    findNavController().navigate(MainFragmentDirections.actionMainFragmentToKasarFragment())
                }
                "3" -> {
                    findNavController().navigate(MainFragmentDirections.actionMainFragmentToHalusFragment())
                }
                "4" -> {
                    findNavController().navigate(MainFragmentDirections.actionMainFragmentToMotorFragment())
                }
                "5" -> {
                    findNavController().navigate(MainFragmentDirections.actionMainFragmentToCegahFragment())
                }
                "6" -> {
                    findNavController().navigate(MainFragmentDirections.actionMainFragmentToBantuFragment())
                }
            }
        }

        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
        })

        ivDetail.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAccountDialog())
        }

        rvHome.apply {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
            adapter = mainAdapter
        }
    }

}