package com.example.myapplication.di.module

import com.example.myapplication.App
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Singleton
    @Provides
    fun app(): App {
        return app
    }

    @Singleton
    @Provides
    fun mainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit = app.getRetrofit()!!

//    @Singleton
//    @Provides
//    fun getRetrofit(): Retrofit = Retrofit.Builder()
//        .baseUrl("http://api.themoviedb.org/")
//        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()


}