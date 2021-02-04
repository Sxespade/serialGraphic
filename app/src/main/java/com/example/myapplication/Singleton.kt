package com.example.myapplication

import com.example.myapplication.di.module.Serial


class Singleton {
    var id = 1
    var save = "1"
    var serial: Serial? = null


    companion object {
        private var INSTANCE: Singleton? = null

        val instance: Singleton
            get() {
                if (INSTANCE == null) {
                    INSTANCE = Singleton()
                }
                return INSTANCE!!
            }
    }
}