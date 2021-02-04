package com.example.myapplication.room.dao

import androidx.room.*
import com.example.myapplication.di.module.SerialRepository

@Dao
interface RepositoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: SerialRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: SerialRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<SerialRepository>)

    @Update
    fun update(user: SerialRepository)

    @Update
    fun update(vararg users: SerialRepository)

    @Update
    fun update(users: List<SerialRepository>)

    @Delete
    fun delete(user: SerialRepository)

    @Delete
    fun delete(vararg users: SerialRepository)

    @Delete
    fun delete(users: List<SerialRepository>)

    @Query("SELECT * FROM SerialRepository")
    fun getAll(): List<SerialRepository>

    @Query("SELECT * FROM SerialRepository WHERE userId = :userId")
    fun findForUser(userId: String): List<SerialRepository>
}

