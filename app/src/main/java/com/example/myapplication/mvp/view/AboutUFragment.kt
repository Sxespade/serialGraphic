package com.example.myapplication.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.di.module.MainView
import com.example.myapplication.mvp.presenter.AboutUPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AboutUFragment: MvpAppCompatFragment(), MainView {

    private val presenter: AboutUPresenter by moxyPresenter {
        AboutUPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    fun getInstance(): AboutUFragment? {
        return AboutUFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_you, container, false)
    }



}