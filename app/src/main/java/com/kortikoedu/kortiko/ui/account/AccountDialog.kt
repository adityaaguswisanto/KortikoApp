package com.kortikoedu.kortiko.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kortikoedu.kortiko.databinding.AccountDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountDialog : DialogFragment() {

    private val viewModel by viewModels<AccountDialogViewModel>()
    private lateinit var binding: AccountDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AccountDialogBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        viewModel.getUser().observe(viewLifecycleOwner, {
            txtNama.text = it.nama
            txtUmurAnak.text = it.umur
            txtNamaOrtu.text = it.ortu
        })

        btnUbah.setOnClickListener {
            findNavController().navigate(AccountDialogDirections.actionAccountDialogToAccountFragment())
        }

    }

}