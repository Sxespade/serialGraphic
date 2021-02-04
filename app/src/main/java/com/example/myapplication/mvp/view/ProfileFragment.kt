package com.example.myapplication.di.module

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.App
import com.example.myapplication.mvp.view.MainView2
import com.example.myapplication.R
import com.example.myapplication.adapters.SerialsAdapter
import com.example.myapplication.mvp.presenter.ProfilePresenter
import com.example.serialgraphicinteres.BackButtonListener
import kotlinx.android.synthetic.main.fragment_find.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ProfileFragment : MvpAppCompatFragment(),
    MainView2, BackButtonListener {


    private val presenter: ProfilePresenter by moxyPresenter {
        ProfilePresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }


    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_find, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        initRec()
        button2.setOnClickListener {
            presenter.findMySerial(multiAutoCompleteTextView.text.toString())
        }
    }

    override fun setRecycle(serialsAdapter: SerialsAdapter) {
        recycleView.adapter = serialsAdapter
        initRec()
    }

    fun initRec() {
        Log.d("xxxxx", "onStart: " + "здесь ок4")
        recycleView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val lp: ViewGroup.LayoutParams = recycleView.layoutParams
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT
        recycleView.requestLayout()
        recycleView.layoutManager = layoutManager
    }

    override fun backPressed(): Boolean {
        TODO("Not yet implemented")
    }


}


