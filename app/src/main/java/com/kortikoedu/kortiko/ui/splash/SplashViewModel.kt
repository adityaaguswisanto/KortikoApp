package com.kortikoedu.kortiko.ui.splash

import androidx.lifecycle.ViewModel
import com.kortikoedu.kortiko.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun getUser() = repository.getUser()

}