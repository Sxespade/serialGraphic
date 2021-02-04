package com.example.myapplication.room.dao

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.App
import com.example.myapplication.di.module.Serial
import com.example.myapplication.di.module.SerialRepository

@androidx.room.Database(entities = [Serial::class, SerialRepository::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun userDao(): UserDao?
    abstract fun repositoryDao(): RepositoryDao?

    companion object {
        private const val DB_NAME = "database.db"

        @Volatile
        private var INSTANCE: Database? = null
        val instance: Database?
            get() {
                var refLocal = INSTANCE
                if (refLocal == null) {
                    synchronized(Database::class.java) {
                        INSTANCE = refLocal
                        if (refLocal == null) {
                            refLocal = Room.databaseBuilder(
                                App.instance.applicationContext,
                                Database::class.java, DB_NAME
                            ).build()
                            INSTANCE = refLocal
                        }
                    }
                }
                return refLocal
            }
    }
}
