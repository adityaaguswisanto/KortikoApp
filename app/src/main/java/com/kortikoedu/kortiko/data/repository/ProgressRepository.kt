package com.kortikoedu.kortiko.data.repository

import com.kortikoedu.kortiko.data.db.AppDatabase
import com.kortikoedu.kortiko.data.db.entities.*
import javax.inject.Inject

class ProgressRepository @Inject constructor(
    private val db: AppDatabase
) {

    fun getUser() = db.userDao().getUser()

    suspend fun upsertUmumProgress(umumProgress: UmumProgress) =
        db.progressDao().upsertUmumProgress(umumProgress)

    fun getUmumProgress() = db.progressDao().getUmumProgress()

    suspend fun upsertHalusProgress(halusProgress: HalusProgress) =
        db.progressDao().upsertHalusProgress(halusProgress)

    fun getHalusProgress() = db.progressDao().getHalusProgress()

    suspend fun upsertKasarProgress(kasarProgress: KasarProgress) =
        db.progressDao().upsertKasarProgress(kasarProgress)

    fun getKasarProgress() = db.progressDao().getKasarProgress()

    suspend fun upsertBantuProgress(bantuProgress: BantuProgress) =
        db.progressDao().upsertBantuProgress(bantuProgress)

    fun getBantuProgress() = db.progressDao().getBantuProgress()

    suspend fun upsertCegahProgress(cegahProgress: CegahProgress) =
        db.progressDao().upsertCegahProgress(cegahProgress)

    fun getCegahProgress() = db.progressDao().getCegahProgress()

    suspend fun upsertMotorProgress(motorProgress: MotorProgress) =
        db.progressDao().upsertMotorProgress(motorProgress)

    fun getMotorProgress() = db.progressDao().getMotorProgress()

}