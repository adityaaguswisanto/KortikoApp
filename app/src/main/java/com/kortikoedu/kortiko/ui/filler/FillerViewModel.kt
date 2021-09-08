package com.kortikoedu.kortiko.ui.filler

import androidx.lifecycle.ViewModel
import com.kortikoedu.kortiko.data.db.entities.User
import com.kortikoedu.kortiko.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FillerViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    suspend fun insertUser(user: User) = repository.insertUser(user)

}