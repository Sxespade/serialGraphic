package com.example.myapplication.mvp.view

import com.example.myapplication.adapters.SerialsAdapter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView4 : MvpView {
    fun setAdapter(serialsAdapter: SerialsAdapter)
}

