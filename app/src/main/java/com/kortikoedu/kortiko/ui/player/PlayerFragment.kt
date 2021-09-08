package com.kortikoedu.kortiko.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kortikoedu.kortiko.databinding.FragmentPlayerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerFragment : Fragment() {

    private val args by navArgs<PlayerFragmentArgs>()
    private lateinit var binding: FragmentPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayerBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        wvPlayer.webViewClient = WebViewClient()
        wvPlayer.loadUrl(args.youtube)
        wvPlayer.settings.javaScriptEnabled = true
        wvPlayer.settings.setSupportZoom(true)
    }

}