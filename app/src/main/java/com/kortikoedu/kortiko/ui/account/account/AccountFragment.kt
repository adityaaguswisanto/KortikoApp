package com.kortikoedu.kortiko.ui.account.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.kortikoedu.kortiko.data.db.entities.User
import com.kortikoedu.kortiko.data.helper.alertDialog
import com.kortikoedu.kortiko.data.helper.toast
import com.kortikoedu.kortiko.databinding.FragmentAccountBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private val viewModel by viewModels<AccountViewModel>()
    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        viewModel.getUser().observe(viewLifecycleOwner,{
            edtNamaAnak.setText(it.nama)
            edtUmurAnak.setText(it.umur)
            edtNamaOrtu.setText(it.ortu)
        })

        btnUbah.setOnClickListener {
            requireContext().alertDialog(
                "Tekan ya jika ingin update data"
            ) { _, _ ->
                userUpdate()
            }
        }
    }

    private fun userUpdate() = with(binding){
        val nama = edtNamaAnak.text.toString()
        val umur = edtUmurAnak.text.toString()
        val ortu = edtNamaOrtu.text.toString()

        if (nama.isEmpty() || umur.isEmpty() || ortu.isEmpty()) {
            requireContext().toast("Field masih kosong")
        } else {
            lifecycleScope.launch {
                viewModel.updateUser(User(nama, umur, ortu))
                requireContext().toast("Data Berhasil diubah")
            }
        }
    }

}