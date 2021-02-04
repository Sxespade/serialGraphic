package com.example.myapplication.di.module

import com.example.myapplication.room.dao.Database
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(): Database = Database.instance!!

}