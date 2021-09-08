package com.kortikoedu.kortiko.ui.video

import androidx.lifecycle.ViewModel
import com.kortikoedu.kortiko.data.db.entities.*
import com.kortikoedu.kortiko.data.repository.ProgressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val repository: ProgressRepository
) : ViewModel() {

    fun getUser() = repository.getUser()

    suspend fun upsertUmumProgress(umumProgress: UmumProgress) = repository.upsertUmumProgress(umumProgress)

    fun getUmumProgress() = repository.getUmumProgress()

    suspend fun upsertHalusProgress(halusProgress: HalusProgress) = repository.upsertHalusProgress(halusProgress)

    fun getHalusProgress() = repository.getHalusProgress()

    suspend fun upsertKasarProgress(kasarProgress: KasarProgress) = repository.upsertKasarProgress(kasarProgress)

    fun getKasarProgress() = repository.getKasarProgress()

    suspend fun upsertBantuProgress(bantuProgress: BantuProgress) = repository.upsertBantuProgress(bantuProgress)

    fun getBantuProgress() = repository.getBantuProgress()

    suspend fun upsertCegahProgress(cegahProgress: CegahProgress) = repository.upsertCegahProgress(cegahProgress)

    fun getCegahProgress() = repository.getCegahProgress()

    suspend fun upsertMotorProgress(motorProgress: MotorProgress) = repository.upsertMotorProgress(motorProgress)

    fun getMotorProgress() = repository.getMotorProgress()

}