package com.example.myapplication.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
import com.example.myapplication.adapters.SerialsAdapter2
import com.example.myapplication.mvp.presenter.GraphicPresenter
import kotlinx.android.synthetic.main.fragment_graphic.recycleView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class GraphicFragment  : MvpAppCompatFragment(),
    MainView5 {

    private val presenter: GraphicPresenter by moxyPresenter {
        GraphicPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }


    fun getInstance(): GraphicFragment? {
        return GraphicFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_graphic, container, false)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun setAdapter(serialsAdapter2: SerialsAdapter2) {
        recycleView.adapter = serialsAdapter2
        initRec()
    }


    fun initRec() {
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