package com.example.myapplication.room.dao

import androidx.room.*
import com.example.myapplication.di.module.Serial

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: Serial)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: Serial)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<Serial>)

    @Update
    fun update(user: Serial)

    @Update
    fun update(vararg users: Serial)

    @Update
    fun update(users: List<Serial>)

    @Delete
    fun delete(user: Serial)

    @Delete
    fun delete(vararg users: Serial)

    @Delete
    fun delete(users: List<Serial>)

    @Query("SELECT * FROM Serial")
    fun getAll(): List<Serial>

    @Query("SELECT * FROM Serial WHERE title = :login LIMIT 1")
    fun findByLogin(login: String): Serial?


}
