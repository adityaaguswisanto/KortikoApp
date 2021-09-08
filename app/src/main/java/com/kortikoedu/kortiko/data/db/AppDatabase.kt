package com.kortikoedu.kortiko.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kortikoedu.kortiko.data.db.dao.*
import com.kortikoedu.kortiko.data.db.entities.*

@Database(
    entities = [
        User::class, UmumProgress::class,
        HalusProgress::class, KasarProgress::class,
        MotorProgress::class, CegahProgress::class,
        BantuProgress::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun progressDao(): ProgressDao

}