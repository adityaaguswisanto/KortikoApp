package com.kortikoedu.kortiko.ui.account

import androidx.lifecycle.ViewModel
import com.kortikoedu.kortiko.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountDialogViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun getUser() = repository.getUser()

}