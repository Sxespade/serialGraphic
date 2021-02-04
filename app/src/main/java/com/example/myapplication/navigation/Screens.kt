package com.example.myapplication.navigation

import com.example.myapplication.di.module.ProfileFragment
import com.example.myapplication.mvp.view.AboutUFragment
import com.example.myapplication.mvp.view.GraphicFragment
import com.example.myapplication.mvp.view.MySerialFragment
import com.example.myapplication.mvp.view.SerialFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class ProfileScreen : SupportAppScreen() {
        override fun getFragment() = ProfileFragment.newInstance()
    }

    class SerialScreen() : SupportAppScreen() {
        override fun getFragment() = SerialFragment()
            .getInstance()
    }

    class MySerialsScreen() : SupportAppScreen() {
        override fun getFragment() = MySerialFragment()
            .getInstance()
    }

    class AboutUScreen() : SupportAppScreen() {
        override fun getFragment() = AboutUFragment()
            .getInstance()
    }

    class GraphicScreen() : SupportAppScreen() {
        override fun getFragment() = GraphicFragment()
            .getInstance()
    }
}
