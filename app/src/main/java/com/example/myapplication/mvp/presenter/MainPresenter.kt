package com.example.myapplication.mvp.presenter

import com.example.myapplication.navigation.Screens
import com.example.myapplication.di.module.MainView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.ProfileScreen())
    }


    fun backClicked() {
//        router.exit()
    }
}

