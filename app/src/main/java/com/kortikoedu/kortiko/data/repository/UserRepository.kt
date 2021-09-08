package com.kortikoedu.kortiko.data.repository

import com.kortikoedu.kortiko.data.db.AppDatabase
import com.kortikoedu.kortiko.data.db.entities.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val db: AppDatabase
){

    suspend fun insertUser(user: User) = db.userDao().insertUser(user)

    fun getUser() = db.userDao().getUser()

    suspend fun updateUser(user: User) = db.userDao().updateUser(user)

}