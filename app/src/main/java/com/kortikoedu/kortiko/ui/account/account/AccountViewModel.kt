package com.kortikoedu.kortiko.ui.account.account

import androidx.lifecycle.ViewModel
import com.kortikoedu.kortiko.data.db.entities.User
import com.kortikoedu.kortiko.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun getUser() = repository.getUser()

    suspend fun updateUser(user: User) = repository.updateUser(user)

}