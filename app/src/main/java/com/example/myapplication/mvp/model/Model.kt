package com.example.myapplication.mvp.model


import android.util.Log
import com.example.myapplication.retrofit.AboutSerial
import com.example.myapplication.di.module.Serial
import com.example.myapplication.retrofit.Example
import com.example.myapplication.retrofit.OpenDataSerialRealise
import com.example.serialgraphicinteres.model.repo.retrofit.OpenFilm
import com.google.gson.internal.LinkedTreeMap
import io.reactivex.rxjava3.core.Observable
import retrofit2.*

class Model {

    fun retrofitDai(name: String, retrofit: Retrofit) = Observable.create<List<Serial>> {

        val openFilm = retrofit!!.create(OpenFilm::class.java)
        openFilm.loadFilmName("f9a3365855819e4489ee8048d1ff8761", name)
            ?.enqueue(object : Callback<Example?> {
                override fun onFailure(call: Call<Example?>, t: Throwable) {
                    Log.d("xxxxx", "onFailure: " + t)
                }

                override fun onResponse(call: Call<Example?>, response: Response<Example?>) {
                    if (response.body() != null) {
                        var results = response.body()!!.results!!
                        it.onNext(results)
                    }
                }

            })
    }


    fun retrofitDai2(str: String, retrofit: Retrofit) = Observable.create<String> {
        val openFilm = retrofit!!.create(OpenDataSerialRealise::class.java)
        openFilm.loadFilmsName(str, "f9a3365855819e4489ee8048d1ff8761", "ru-RU")
            ?.enqueue(object : Callback<AboutSerial?> {
                override fun onResponse(
                    call: Call<AboutSerial?>?,
                    response: Response<AboutSerial?>
                ) {
                    if (response.body() != null) {
                        val nextEpisodeToAir = response.body()!!.nextEpisodeToAir
                        Log.d("bbbbbb", "onResponse: " + response)
                        if (nextEpisodeToAir.toString().length > 15) {
                            val map = response.body()!!.nextEpisodeToAir as LinkedTreeMap<*, *>
                            it.onNext(map.get("air_date").toString())} else {it.onNext("Дата выхода следующей серии неизвестна")}
                    }

                }
                override fun onFailure(call: Call<AboutSerial?>?, t: Throwable) {
                }
            })
    }!!
}

