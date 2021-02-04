package com.example.myapplication.mvp.presenter

import android.util.Log
import com.example.myapplication.mvp.view.MainView3
import com.example.myapplication.Singleton
import com.example.myapplication.mvp.model.Model
import com.example.myapplication.room.dao.Database
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers.io
import moxy.MvpPresenter
import retrofit2.Retrofit
import javax.inject.Inject


class SerialPresenter : MvpPresenter<MainView3>() {

    var obj = Object()
    var serialLocal = Singleton.instance.serial

    @Inject
    lateinit var retrofit: Retrofit
    var model = Model()

    @Inject
    lateinit var database: Database


    fun checkdb() {
        Thread(Runnable {
            val db = database.userDao()
            val listNames = mutableListOf<String>()
            Log.d("kkkkk", "checkdb: 1")

            Observable.create<List<String>> {
                val listNames = mutableListOf<String>()
                if (db?.getAll() != null) {
                    Log.d("kkkkk", "checkdb: 2")
                    for (names in db.getAll()) {
                        listNames.add(names.title)
                    }
                    it.onNext(listNames)
                }
            }.subscribeOn(io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
                if (it.contains(serialLocal!!.title)) {
                    viewState.openBut5()
                } else {
                    viewState.openBut()
                }
            }
        }).start()
    }


    fun putSerialInDatabase() {
        val serial = serialLocal
        if (serial != null) {
            model.retrofitDai2(serial.id, retrofit).subscribeOn(io()).subscribe {
                serial.nextAir = it
                Log.d("bbbbb", "putSerialInDatabase: " + it)
                Thread(Runnable {
                    val db = com.example.myapplication.room.dao.Database.instance!!.userDao()
                    db!!.insert(serial)
                    Singleton.instance.serial = null
                    for (attachedView in db.getAll()) {
                        Log.d("xxxxx", "putSerialInDatabase: " + attachedView.title)
                    }
                }).start()
            }

        }

    }

    fun deleSerialFromDatabase() {
        synchronized(obj) {
            Thread(Runnable {
                val db = com.example.myapplication.room.dao.Database.instance!!.userDao()
                serialLocal?.let { db!!.delete(it) }
                for (attachedView in db!!.getAll()) {
                    Log.d("xxxxx", "putSerialInDatabase: " + attachedView.title)
                }
            }).start()
        }
    }


}
