package com.kortikoedu.kortiko.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kortikoedu.kortiko.data.db.entities.CURRENT_USER_ID
import com.kortikoedu.kortiko.data.db.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>

    @Update
    suspend fun updateUser(user: User)

}