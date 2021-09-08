package com.kortikoedu.kortiko.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kortikoedu.kortiko.data.db.entities.*

@Dao
interface ProgressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUmumProgress(umumProgress: UmumProgress): Long

    @Query("SELECT * FROM umumprogress ORDER BY id ASC")
    fun getUmumProgress(): LiveData<UmumProgress>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertHalusProgress(halusProgress: HalusProgress): Long

    @Query("SELECT * FROM halusprogress ORDER BY id ASC")
    fun getHalusProgress(): LiveData<HalusProgress>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertKasarProgress(kasarProgress: KasarProgress): Long

    @Query("SELECT * FROM kasarprogress ORDER BY id ASC")
    fun getKasarProgress(): LiveData<KasarProgress>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertBantuProgress(bantuProgress: BantuProgress): Long

    @Query("SELECT * FROM bantuprogress ORDER BY id ASC")
    fun getBantuProgress(): LiveData<BantuProgress>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCegahProgress(cegahProgress: CegahProgress): Long

    @Query("SELECT * FROM cegahprogress ORDER BY id ASC")
    fun getCegahProgress(): LiveData<CegahProgress>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMotorProgress(motorProgress: MotorProgress): Long

    @Query("SELECT * FROM motorprogress ORDER BY id ASC")
    fun getMotorProgress(): LiveData<MotorProgress>

}