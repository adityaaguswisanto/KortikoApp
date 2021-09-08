package com.kortikoedu.kortiko.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kortikoedu.kortiko.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private val viewModel by viewModels<SplashViewModel>()
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.getUser().observe(viewLifecycleOwner, {
                if (it == null) {
                    findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToFillerFragment())
                } else {
                    findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
                }
            })
        }, 3000)
    }

}