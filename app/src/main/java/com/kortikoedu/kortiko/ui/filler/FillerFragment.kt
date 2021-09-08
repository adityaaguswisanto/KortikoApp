package com.kortikoedu.kortiko.ui.filler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.kortikoedu.kortiko.data.db.entities.User
import com.kortikoedu.kortiko.data.helper.alertDialog
import com.kortikoedu.kortiko.data.helper.toast
import com.kortikoedu.kortiko.databinding.FragmentFillerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FillerFragment : Fragment() {

    private val viewModel by viewModels<FillerViewModel>()
    private lateinit var binding: FragmentFillerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFillerBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        btnMasuk.setOnClickListener {
            requireContext().alertDialog(
                "Tekan ya jika ingin masuk",
            ) { _, _ ->
                inputUser()
            }
        }
    }

    private fun inputUser() = with(binding) {
        val nama = edtNamaAnak.text.toString()
        val umur = edtUmurAnak.text.toString()
        val ortu = edtNamaOrtu.text.toString()

        if (nama.isEmpty() || umur.isEmpty() || ortu.isEmpty()) {
            requireContext().toast("Field masih kosong")
        } else {
            lifecycleScope.launch {
                viewModel.insertUser(User(nama, umur, ortu))
                findNavController().navigate(FillerFragmentDirections.actionFillerFragmentToMainFragment())
            }
        }

    }

}