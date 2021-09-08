package com.kortikoedu.kortiko.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User(
    val nama: String? = null,
    val umur: String? = null,
    val ortu : String? = null,
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}