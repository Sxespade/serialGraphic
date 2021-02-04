package com.example.myapplication.mvp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
import com.example.myapplication.adapters.SerialsAdapter
import com.example.myapplication.mvp.presenter.MySerialPresenter
import kotlinx.android.synthetic.main.my_serial_fragment.recycleView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MySerialFragment : MvpAppCompatFragment(),
    MainView4 {

    private val presenter: MySerialPresenter by moxyPresenter {
        MySerialPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }


    fun getInstance(): MySerialFragment? {
        return MySerialFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_serial_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun setAdapter(serialsAdapter: SerialsAdapter) {
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


}