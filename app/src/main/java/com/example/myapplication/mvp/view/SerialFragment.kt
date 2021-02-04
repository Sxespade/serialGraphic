package com.example.myapplication.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.Singleton
import com.example.myapplication.mvp.presenter.SerialPresenter
import com.example.myapplication.mvp.view.image.GlideImageLoader
import kotlinx.android.synthetic.main.fragment_serial.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SerialFragment : MvpAppCompatFragment(),
    MainView3 {

    private val imageLoader = GlideImageLoader()

    private val presenter: SerialPresenter by moxyPresenter {
        SerialPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }


    fun getInstance(): SerialFragment? {
        return SerialFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }





    override fun onStart() {
        super.onStart()
        button.isEnabled = false
        button5.isEnabled = false


        presenter.checkdb()


        button.setOnClickListener {
            button.isEnabled = false
            presenter.putSerialInDatabase()
            button5.isEnabled = true

        }

        button5.setOnClickListener {
            presenter.deleSerialFromDatabase()
            button.isEnabled = true
            button5.isEnabled = false
        }

        val serial = Singleton.instance.serial
        if (serial != null) {
            title.text = serial!!.title
            imageLoader.loadImage(
                "https://image.tmdb.org/t/p/w500" + serial.poster,
                imageView
            )
        }

    }


    override fun openBut() {
        button.isEnabled = true
    }

    override fun openBut5() {
        button5.isEnabled = true
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_serial, container, false)
        return view
    }

}
