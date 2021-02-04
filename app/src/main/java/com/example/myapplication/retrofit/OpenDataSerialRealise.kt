package com.example.myapplication.retrofit

import com.example.myapplication.retrofit.AboutSerial
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenDataSerialRealise {
    @GET("3/tv/{id}")
    fun loadFilmsName(
        @Path("id") s: String,
        @Query("api_key") m: String?,
        @Query("language") keyApi: String?
    ): Call<AboutSerial?>?
}