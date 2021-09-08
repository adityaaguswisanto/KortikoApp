package com.kortikoedu.kortiko.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UmumProgress(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val progress: String
)

@Entity
data class HalusProgress(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val progress: String
)

@Entity
data class KasarProgress(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val progress: String
)

@Entity
data class MotorProgress(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val progress: String
)

@Entity
data class CegahProgress(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val progress: String
)

@Entity
data class BantuProgress(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val progress: String
)