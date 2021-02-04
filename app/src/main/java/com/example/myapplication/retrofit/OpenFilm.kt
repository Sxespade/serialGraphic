package com.example.serialgraphicinteres.model.repo.retrofit

import com.example.myapplication.retrofit.Example
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenFilm {
    @GET("3/search/tv")
    fun loadFilmName(
        @Query("api_key") m: String?,
        @Query("query") keyApi: String?
    ): Call<Example?>?

}